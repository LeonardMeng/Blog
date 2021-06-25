package org.mengsoft.webbackend.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.dynamic.scaffold.MethodGraph.Linked;
import org.apache.ibatis.session.RowBounds;
import org.mengsoft.webbackend.common.enums.ResponseCode;
import org.mengsoft.webbackend.common.exceptions.BusinessException;
import org.mengsoft.webbackend.common.utils.Paging;
import org.mengsoft.webbackend.common.utils.Tools;
import org.mengsoft.webbackend.dao.AnswerMapper;
import org.mengsoft.webbackend.dao.QuestionMapper;
import org.mengsoft.webbackend.dao.QuestionWrongRecordMapper;
import org.mengsoft.webbackend.model.Answer;
import org.mengsoft.webbackend.model.Article;
import org.mengsoft.webbackend.model.Question;
import org.mengsoft.webbackend.model.QuestionWrongRecord;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

@Service("questionService")
@Slf4j
public class QuestionService {

  @Resource
  private QuestionMapper questionMapper;
  @Resource
  private AnswerMapper answerMapper;
  @Resource
  private QuestionWrongRecordMapper questionWrongRecordMapper;

  public Map<String, Object> getQuestionBySelection(Question question, Paging paging) {
    Map<String, Object> resultMap = new HashMap<String, Object>();

    Example example = new Example(Question.class);
    Example.Criteria criteria = example.createCriteria();

    if (question.getChapterId() != null) {
      criteria.andEqualTo("chapterId", question.getChapterId());
    }

    List<Question> questionList = this.questionMapper.selectByExampleAndRowBounds(example,
        new RowBounds((paging.getCurrentPage() - 1) * paging.getPageSize(),
            (paging.getPageSize())));

    paging.setTotal(this.questionMapper.selectCountByExample(example));
    resultMap.put("questionList", questionList);
    resultMap.put("paging", paging);
    return resultMap;
  }

  public String getSolution(String id) {
    Answer answer = new Answer();
    answer.setQuestionId(Integer.parseInt(id));
    Answer answer1 = this.answerMapper.selectByPrimaryKey(answer);
    return answer1 == null ? "暂无解析" : answer1.getQuestionAnswer();
  }

  public boolean addQuestion(Question question, String solution) {
    int id = this.questionMapper.selectMaxID() + 1;
    question.setQuestionId(id);
    this.questionMapper.insert(question);
    Answer answer = new Answer();
    answer.setQuestionId(id);
    answer.setQuestionAnswer(solution);
    this.answerMapper.insert(answer);

    return true;
  }

  public Map<String, Object> getQuestion(Map<String, String> searching, Paging paging) {
    Map<String, Object> resultMap = new HashMap<>();

    Example example = new Example(Question.class);
    Example.Criteria criteria = example.createCriteria();

    if (searching.get("chapters") != null) {
      String[] chapterList = searching.get("chapters").split("\\|");
      for (String chapter : chapterList) {
        criteria.orEqualTo("chapterId", Integer.parseInt(chapter));
      }
    }

    List<Question> questionList = new ArrayList<>();

    if (paging == null) {
      questionList = this.questionMapper.selectByExample(example);
    }

    Example questionWrongRecordExample = new Example(QuestionWrongRecord.class);
    Example.Criteria criteria2 = questionWrongRecordExample.createCriteria();

    if (searching.get("userId") != null) {
      criteria2.orEqualTo("userId", searching.get("userId"));


    }
    List<QuestionWrongRecord> recordList = this.questionWrongRecordMapper
        .selectByExample(questionWrongRecordExample);
    List<Integer> wrongRecord = new ArrayList<>();
    if (searching.get("number") != null) {
      String mode = searching.get("mode") == null ? "1" : searching.get("mode");
      if (mode.equals("1")) {
        questionList = Tools.getRandomList(questionList, Integer.parseInt(searching.get("number")));
        for (int i = 0; i < questionList.size(); i++) {
          for (int j = 0; j < recordList.size(); j++) {
            if (questionList.get(i).getQuestionId() == recordList.get(j).getQuestionId()) {
              wrongRecord.add(questionList.get(i).getQuestionId());
            }
          }
        }
      } else if (mode.equals("2")){
        for (int i = questionList.size() - 1; i >= 0 ; i--) {
          for (int j = 0; j < recordList.size(); j++) {
            if (questionList.get(i).getQuestionId() == recordList.get(j).getQuestionId()) {
              questionList.remove(i);
            }
          }
        }

        questionList = Tools.getRandomList(questionList, Integer.parseInt(searching.get("number")));
      } else {
        List<Question> questionList1 = questionList;
        questionList = new ArrayList<>();
        for (int i = 0; i < recordList.size() ; i++) {
          for (int j = 0; j < questionList1.size(); j++) {
            if (questionList1.get(j).getQuestionId() == recordList.get(i).getQuestionId()) {
              questionList.add(questionList1.get(j));
              wrongRecord.add(recordList.get(i).getQuestionId());
            }
          }
        }

        questionList = Tools.getRandomList(questionList, Integer.parseInt(searching.get("number")));
      }

//      System.out.println(wrongRecord);
      resultMap.put("questionList", questionList);
      resultMap.put("wrongRecord", wrongRecord);
    }
    return resultMap;
  }

  public List<QuestionWrongRecord> getWrongQuestion(int userId) {
    Example example = new Example(QuestionWrongRecord.class);
    Example.Criteria criteria = example.createCriteria();
    criteria.andEqualTo("userId", userId);

    return this.questionWrongRecordMapper.selectByExample(example);

  }

  public boolean addWrongRecord(Map<String, String> param) {
    int userId = Integer.parseInt(param.get("userId"));
    int questionId = Integer.parseInt(param.get("questionId"));

    Example example = new Example(QuestionWrongRecord.class);
    Example.Criteria criteria = example.createCriteria();
    criteria.andEqualTo("userId", userId);
    criteria.andEqualTo("questionId", questionId);
    List<QuestionWrongRecord> recordList = this.questionWrongRecordMapper.selectByExample(example);
    if (recordList.size() > 0) {
      throw new BusinessException(ResponseCode.QUESTION_ALREADY_EXIST);
    }
    QuestionWrongRecord questionWrongRecord = new QuestionWrongRecord();
    questionWrongRecord.setQuestionId(questionId);
    questionWrongRecord.setUserId(userId);
    this.questionWrongRecordMapper.insert(questionWrongRecord);
    return true;
  }

  public boolean deleteWrongRecord(Map<String, String> param) {
    int userId = Integer.parseInt(param.get("userId"));
    int questionId = Integer.parseInt(param.get("questionId"));

    Example example = new Example(QuestionWrongRecord.class);
    Example.Criteria criteria = example.createCriteria();
    criteria.andEqualTo("userId", userId);
    criteria.andEqualTo("questionId", questionId);

    this.questionWrongRecordMapper.deleteByExample(example);
    return true;
  }
}
