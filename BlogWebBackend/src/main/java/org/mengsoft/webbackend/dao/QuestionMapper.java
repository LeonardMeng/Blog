package org.mengsoft.webbackend.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mengsoft.webbackend.model.Question;

import tk.mybatis.mapper.common.Mapper;

public interface QuestionMapper extends Mapper<Question> {

    int selectMaxID();
}