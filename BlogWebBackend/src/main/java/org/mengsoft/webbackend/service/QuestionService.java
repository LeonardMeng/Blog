package org.mengsoft.webbackend.service;

import java.util.List;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.mengsoft.webbackend.dao.AnswerMapper;
import org.mengsoft.webbackend.dao.QuestionMapper;
import org.mengsoft.webbackend.model.Answer;
import org.mengsoft.webbackend.model.Question;
import org.springframework.stereotype.Service;

@Service("questionService")
@Slf4j
public class QuestionService {

    @Resource
    private QuestionMapper questionMapper;
    @Resource
    private AnswerMapper answerMapper;

    public List<Question> getAllQuestions(){
        return this.questionMapper.selectAll();
    }

    public String getSolution(String id) {
        Answer answer = new Answer();
        answer.setQuestionId(Integer.parseInt(id));
        Answer answer1 = this.answerMapper.selectByPrimaryKey(answer);
        return answer1 == null? "暂无解析" : answer1.getQuestionAnswer();
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
}
