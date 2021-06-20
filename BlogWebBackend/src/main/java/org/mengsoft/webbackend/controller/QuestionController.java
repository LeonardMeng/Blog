package org.mengsoft.webbackend.controller;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
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

    @RequestMapping(value="/question/getAllQuestions", method= RequestMethod.GET, produces="application/json")
    public List<Question> getAllQuestions(){
        return this.questionService.getAllQuestions();
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
}
