package org.mengsoft.webbackend.service;

import tk.mybatis.mapper.entity.Example;
import lombok.extern.slf4j.Slf4j;
import org.mengsoft.webbackend.dao.TagMapper;
import org.mengsoft.webbackend.model.Tag;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("tagService")
@Slf4j
public class TagService {
    @Resource
    private TagMapper tagMapper;

    public List<Tag> getAllTags() {
        List<Tag> tagList = this.tagMapper.selectAll();
        return tagList;
    }

    public List<Tag> selectTagsByUsername(String username) {
//        Example tagExample = new Example(Tag.class);
//        Example.Criteria tagCriteria = tagExample.createCriteria();
//        tagCriteria.andEqualTo("owner", username);
        return this.tagMapper.selectTagsByUsername(username);
    }

}
