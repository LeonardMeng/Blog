package org.mengsoft.webbackend.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mengsoft.webbackend.model.User;
import tk.mybatis.mapper.common.Mapper;

public interface UserMapper extends Mapper<User> {
}