package org.mengsoft.webbackend.service;


import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.mengsoft.webbackend.common.enums.ResponseCode;
import org.mengsoft.webbackend.common.exceptions.BusinessException;
import org.mengsoft.webbackend.dao.UserMapper;
import org.mengsoft.webbackend.model.User;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Slf4j
public class UserService {

  @Resource
  private UserMapper userMapper;
  @Resource
  private EmailService emailService;


  public List<User> GetUserByUsername(String username) {
    Example userExample = new Example(User.class);
    Example.Criteria userCriteria = userExample.createCriteria();

    userCriteria.andEqualTo("userName", username);
    List<User> userList = this.userMapper.selectByExample(userExample);
    if (userList.size() > 0) {
      return userList;
    } else {
      throw new BusinessException(ResponseCode.USER_IS_NOT_EXISTED);
    }
  }

  public List<User> getAllUser() {
    return this.userMapper.selectAll();
  }
}
