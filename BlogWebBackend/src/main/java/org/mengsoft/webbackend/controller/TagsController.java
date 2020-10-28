package org.mengsoft.webbackend.controller;

import lombok.extern.slf4j.Slf4j;
import org.mengsoft.webbackend.model.Tag;
import org.mengsoft.webbackend.model.User;
import org.mengsoft.webbackend.service.TagService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@RestController
@EnableAutoConfiguration
@Slf4j
public class TagsController {

    @Resource
    private TagService tagService;

    @RequestMapping(value="/tag/getTagsByUsername", method= RequestMethod.POST, produces="application/json")
    public List<Tag> selectTagsByUsername(@RequestHeader("User") String username){
        return this.tagService.selectTagsByUsername(username);
    }
}
