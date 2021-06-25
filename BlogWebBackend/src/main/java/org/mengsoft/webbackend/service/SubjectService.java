package org.mengsoft.webbackend.service;


import java.util.List;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.mengsoft.webbackend.dao.SubjectMapper;
import org.mengsoft.webbackend.model.Subject;
import org.springframework.stereotype.Service;

@Service("subjectService")
@Slf4j
public class SubjectService {

  @Resource
  SubjectMapper subjectMapper;

  public List<Subject> getAllSubject(){
    return this.subjectMapper.selectAll();
  }
}
