package org.mengsoft.webbackend.controller;


import java.util.List;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.mengsoft.webbackend.model.Chapter;
import org.mengsoft.webbackend.model.Subject;
import org.mengsoft.webbackend.service.ChapterService;
import org.mengsoft.webbackend.service.SubjectService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@Slf4j
public class SubjectController {
  @Resource
  SubjectService subjectService;

  @RequestMapping(value="/subject/getAllSubject", method= RequestMethod.GET, produces="application/json")
  public List<Subject> getAllSubject(){
    return this.subjectService.getAllSubject();
  }
}
