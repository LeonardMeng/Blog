package org.mengsoft.webbackend.controller;

import lombok.extern.slf4j.Slf4j;
import org.mengsoft.webbackend.model.Category;
import org.mengsoft.webbackend.model.MenuItem;
import org.mengsoft.webbackend.model.User;
import org.mengsoft.webbackend.service.CategoryService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@RestController
@EnableAutoConfiguration
@Slf4j
public class CategoryController {

    @Resource
    private CategoryService categoryService;

    @RequestMapping(value="/category/getallcategory", method= RequestMethod.POST, produces="application/json")
    public List<Category> GetAllCategory(@RequestBody String username){

        return this.categoryService.GetAllCategory();
    }
}
