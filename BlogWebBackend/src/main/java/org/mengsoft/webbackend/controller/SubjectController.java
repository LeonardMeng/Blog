package org.mengsoft.webbackend.controller;


import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.mengsoft.webbackend.common.utils.Request;
import org.mengsoft.webbackend.model.Chapter;
import org.mengsoft.webbackend.model.Subject;
import org.mengsoft.webbackend.service.ChapterService;
import org.mengsoft.webbackend.service.SubjectService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@Slf4j
public class SubjectController {
  @Resource
  SubjectService subjectService;

  @RequestMapping(value="/subject/getSubject", method= RequestMethod.POST, produces="application/json")
  public Map<String, Object> getSubject(@RequestBody Request<Map<String, String>> param){
    Map<String, String> query = param.getModel();
    return this.subjectService.getSubject(query);
  }
}
