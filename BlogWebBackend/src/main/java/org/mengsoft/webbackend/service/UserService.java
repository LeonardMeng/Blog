package org.mengsoft.webbackend.service;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.mengsoft.webbackend.common.enums.ResponseCode;
import org.mengsoft.webbackend.common.exceptions.BusinessException;
import org.mengsoft.webbackend.dao.SSOUserMapper;
import org.mengsoft.webbackend.dao.UserMapper;
import org.mengsoft.webbackend.model.SSOUser;
import org.mengsoft.webbackend.model.User;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import tk.mybatis.mapper.entity.Example;
import java.util.UUID;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Slf4j
public class UserService {

  @Resource
  private UserMapper userMapper;
  @Resource
  private SSOUserMapper ssoUserMapper;
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

  public Map<String, Object> login(User user) {
    Example userExample = new Example(User.class);
    Example.Criteria userCriteria = userExample.createCriteria();

    userCriteria.andEqualTo("userName", user.getUserName());
    userCriteria.andEqualTo("password", user.getPassword());
    List<User> userList = this.userMapper.selectByExample(userExample);
    if(userList.size() != 1)
      throw new BusinessException(ResponseCode.AUTHORITY_AUTHENTICATION_FAILED);
    Map<String, Object> resultMap = new HashMap<>();
    String token = UUID.randomUUID().toString().replaceAll("-","");
    resultMap.put("user", userList.get(0));
    SSOUser ssoUser = new SSOUser();
    Long id = userList.get(0).getUserId();
    ssoUser.setUserId(Math.toIntExact(id));
    ssoUser.setToken(token);
    ssoUser.setCreateDate(new Date());
    this.ssoUserMapper.insert(ssoUser);
    resultMap.put("token", token);

    return resultMap;
  }
}
