package org.mengsoft.webbackend.controller;

import lombok.extern.slf4j.Slf4j;
import org.mengsoft.webbackend.model.Tag;
import org.mengsoft.webbackend.model.User;
import org.mengsoft.webbackend.service.TagService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@RestController
@EnableAutoConfiguration
@Slf4j
public class TagsController {

    @Resource
    private TagService tagService;

    @RequestMapping(value="/tag/getalltags", method= RequestMethod.GET, produces="application/json")
    public List<String> GetUserByUsername(){
        return this.tagService.GetAllTags();
    }
}
