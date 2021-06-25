package org.mengsoft.webbackend.service;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.mengsoft.webbackend.common.enums.ResponseCode;
import org.mengsoft.webbackend.common.exceptions.BusinessException;
import org.mengsoft.webbackend.dao.SSOUserMapper;
import org.mengsoft.webbackend.model.Question;
import org.mengsoft.webbackend.model.SSOUser;
import org.mengsoft.webbackend.model.User;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

@Service("SSOService")
@Slf4j
public class SSOService {

  @Resource
  private SSOUserMapper ssoUserMapper;

  public boolean checkPermission(String uri, String token) {
    return true;
  }

  public boolean checkToken(Integer userId, String token) {
    Example ssoUserExample = new Example(SSOUser.class);
    Example.Criteria criteria = ssoUserExample.createCriteria();

    if (userId == null) {
      throw new BusinessException(ResponseCode.USER_HAS_NOT_LOGIN);
    }

    criteria.andEqualTo("userId", userId);
    criteria.andEqualTo("token", token);

    List<SSOUser> ssoUserList = this.ssoUserMapper.selectByExample(ssoUserExample);
    if (ssoUserList.size() != 1) {
      throw new BusinessException(ResponseCode.CHECK_TOKEN_FAIL);
    }
    SSOUser ssoUser = ssoUserList.get(0);
    Date createDate = ssoUser.getCreateDate();
    Date currDate = new Date(); //取时间

    Calendar createCalendar = new GregorianCalendar();
    createCalendar.setTime(createDate);
    createCalendar.add(createCalendar.DATE, 1); //把日期往后增加一天,整数  往后推,负数往前移动
    createDate = createCalendar.getTime(); //这个时间就是日期往后推一天的结果
    if(createDate.compareTo(currDate) < 0)
      throw new BusinessException(ResponseCode.CHECK_TOKEN_FAIL);

    return true;
  }
}
