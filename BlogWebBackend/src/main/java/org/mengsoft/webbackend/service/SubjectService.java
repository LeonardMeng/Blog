package org.mengsoft.webbackend.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.mengsoft.webbackend.dao.SubjectMapper;
import org.mengsoft.webbackend.model.Question;
import org.mengsoft.webbackend.model.Subject;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

@Service("subjectService")
@Slf4j
public class SubjectService {

  @Resource
  SubjectMapper subjectMapper;

  public List<Subject> getAllSubject(){
    return this.subjectMapper.selectAll();
  }

  public Map<String, Object> getSubject(Map<String, String> query) {
    String field = query.get("field") == null|| query.get("field").equals("") ? "Mathematics": query.get("field");
    Example example = new Example(Subject.class);
    Example.Criteria criteria = example.createCriteria();
    criteria.andEqualTo("fatherSubjectName", field);
    Map<String, Object> resultMap = new HashMap<>();
    resultMap.put("subjectList", this.subjectMapper.selectByExample(example));

    return resultMap;
  }
}
