package org.mengsoft.webbackend.controller;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.mengsoft.webbackend.common.utils.Paging;
import org.mengsoft.webbackend.common.utils.Request;
import org.mengsoft.webbackend.model.Question;
import org.mengsoft.webbackend.service.QuestionService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@Slf4j
public class QuestionController {
    @Resource
    QuestionService questionService;

    @RequestMapping(value="/question/getQuestionBySelection", method= RequestMethod.POST, produces="application/json")
    public Map<String, Object> getQuestionBySelection(@RequestBody Request<Question> param){
        Question question = param.getModel();
        Paging paging = param.getPaging();
        return this.questionService.getQuestionBySelection(question, paging);
    }

    @RequestMapping(value="/question/getQuestion", method= RequestMethod.POST, produces="application/json")
    public Map<String,Object> getQuestion(@RequestBody Request<Map<String, String>> param){
        Map<String, String> searching = param.getModel();
        Paging paging = param.getPaging();
        return this.questionService.getQuestion(searching, paging);
    }

    @RequestMapping(value="/question/getSolution", method= RequestMethod.POST, produces="application/json")
    public String getSolution(@RequestBody Map<String, String> param){
        String id = param.get("id");
        return this.questionService.getSolution(id);
    }

    @RequestMapping(value="/question/addQuestion", method= RequestMethod.POST, produces="application/json")
    public String addQuestion(@RequestBody Request<Question> param){
        Question question = param.getModel();
        String solution = param.getInfo();
        this.questionService.addQuestion(question, solution);
        return "Hello World";
    }
    @RequestMapping(value="/question/getWrongQuestion", method= RequestMethod.POST, produces="application/json")
    public String getWrongQuestion(@RequestBody Request<Question> param){
        Question question = param.getModel();
        String solution = param.getInfo();
        this.questionService.getWrongQuestion(1);
        return "Hello World";
    }
    @RequestMapping(value="/question/addWrongRecord", method= RequestMethod.POST, produces="application/json")
    public Boolean addWrongRecord(@RequestBody Request<Map<String, String>> param){
        Map<String, String> map = param.getModel();
        this.questionService.addWrongRecord(map);
        return true;
    }


    @RequestMapping(value="/question/deleteWrongRecord", method= RequestMethod.POST, produces="application/json")
    public boolean deleteWrongRecord(@RequestBody Request<Map<String, String>> param){
        Map<String, String> map = param.getModel();
        this.questionService.deleteWrongRecord(map);
        return true;
    }
}
