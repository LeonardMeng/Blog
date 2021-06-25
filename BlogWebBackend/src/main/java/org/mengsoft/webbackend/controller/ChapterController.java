package org.mengsoft.webbackend.controller;


import java.util.List;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.mengsoft.webbackend.common.utils.Request;
import org.mengsoft.webbackend.model.Chapter;
import org.mengsoft.webbackend.model.Question;
import org.mengsoft.webbackend.service.ChapterService;
import org.mengsoft.webbackend.service.QuestionService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@Slf4j
public class ChapterController {
  @Resource
  ChapterService chapterService;

  @RequestMapping(value="/chapter/getChapter", method= RequestMethod.POST, produces="application/json")
  public List<Chapter> getChapter(@RequestBody Request<Chapter> param){
    Chapter chapter = param.getModel();
    return this.chapterService.getChapter(chapter);
  }

  @RequestMapping(value="/chapter/addChapter", method= RequestMethod.POST, produces="application/json")
  public boolean addChapter(@RequestBody Request<Chapter> param){
    Chapter chapter = param.getModel();
    return this.chapterService.addChapter(chapter);
  }
}
