package org.mengsoft.webbackend.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@Slf4j
public class SSOController {

  @RequestMapping(value = "/user/login", method = RequestMethod.POST, produces = "application/json")
  public boolean login(){
    return true;
  }
}
