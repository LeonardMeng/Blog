package org.mengsoft.webbackend.service;

import java.util.HashMap;
import java.util.Map;
import org.apache.ibatis.session.RowBounds;
import org.mengsoft.webbackend.common.utils.Paging;
import org.mengsoft.webbackend.common.utils.Request;
import org.mengsoft.webbackend.model.Article;
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
    return this.tagMapper.selectAll();
  }

  public List<Tag> selectTagsByUsername(String username) {
//        Example tagExample = new Example(Tag.class);
//        Example.Criteria tagCriteria = tagExample.createCriteria();
//        tagCriteria.andEqualTo("owner", username);
    return this.tagMapper.selectTagsByUsername(username);
  }

  public Map<String, Object> getTagsByBound(Request<Map<String, String>> param) {
    Paging paging = param.getPaging();
    Example example = new Example(Tag.class);
    Example.Criteria criteria = example.createCriteria();

    List<Tag> tagList = this.tagMapper.selectByExampleAndRowBounds(example,
        new RowBounds((paging.getCurrentPage() - 1) * paging.getPageSize(),
            (paging.getCurrentPage() * paging.getPageSize())));

    Map<String, Object> resultMap = new HashMap<String, Object>();
    paging.setTotal(this.tagMapper.selectCountByExample(example));
    resultMap.put("tagList", tagList);
    resultMap.put("paging", paging);
    return resultMap;
  }

  public boolean addTag(Tag tag){
    this.tagMapper.insert(tag);
    return true;
  }
}
