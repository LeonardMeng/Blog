package org.mengsoft.webbackend.controller;


import java.util.Map;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.mengsoft.webbackend.common.utils.Request;
import org.mengsoft.webbackend.dao.UserMapper;
import org.mengsoft.webbackend.model.User;
import org.mengsoft.webbackend.service.SSOService;
import org.mengsoft.webbackend.service.UserService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@Slf4j
public class SSOController {
  @Resource
  private UserService userService;
  @Resource
  private SSOService ssoService;

  @RequestMapping(value = "/user/login", method = RequestMethod.POST, produces = "application/json")
  public Map<String, Object> login(@RequestBody Request<User> param){
    User user = param.getModel();

    return this.userService.login(user);
  }

  @RequestMapping(value = "/sso/checkToken", method = RequestMethod.POST, produces = "application/json")
  public boolean checkToken(@RequestHeader("UserId") String userId,
                            @RequestHeader("Access-Token") String token){

    System.out.println(userId);
    System.out.println(token);
    return this.ssoService.checkToken(Integer.parseInt(userId), token);
  }
}
