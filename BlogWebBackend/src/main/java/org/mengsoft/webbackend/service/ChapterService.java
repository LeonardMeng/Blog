package org.mengsoft.webbackend.service;


import java.util.List;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.mengsoft.webbackend.dao.ChapterMapper;
import org.mengsoft.webbackend.model.Chapter;
import org.mengsoft.webbackend.model.User;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

@Service("chapterService")
@Slf4j
public class ChapterService {
  @Resource
  private ChapterMapper chapterMapper;

  public List<Chapter> getChapter(Chapter chapter){
    Example chapterExample = new Example(Chapter.class);
    Example.Criteria chapterExampleCriteria = chapterExample.createCriteria();
    if(chapter.getSubjectId() != null){
      chapterExampleCriteria.andEqualTo("subjectId", chapter.getSubjectId());
    }

    return this.chapterMapper.selectByExample(chapterExample);
  }

  public boolean addChapter(Chapter chapter) {
    this.chapterMapper.insert(chapter);
    return true;
  }
}
