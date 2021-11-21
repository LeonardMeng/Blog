package org.mengsoft.webbackend.controller;

import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.mengsoft.webbackend.common.utils.Paging;
import org.mengsoft.webbackend.common.utils.Request;
import org.mengsoft.webbackend.model.Tag;
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

    @RequestMapping(value="/tag/getAllTags", method= RequestMethod.POST, produces="application/json")
    public List<Tag> getAllTags(){
        return this.tagService.getAllTags();
    }

    @RequestMapping(value="/tag/getTagsByBound", method= RequestMethod.POST, produces="application/json")
    public List<Tag> getTagsByBound(@RequestBody(required = false) Request<Map<String, String>> param) {
//        System.out.println(param);
//        return null;
        return this.tagService.getTagsByBound(param);
    }

    @RequestMapping(value="/tag/addTag", method= RequestMethod.POST, produces="application/json")
    public boolean addTag(@RequestBody Tag tag){
        return this.tagService.addTag(tag);
    }
}
