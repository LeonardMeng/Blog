package org.mengsoft.webbackend.controller;

import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.mengsoft.webbackend.common.utils.Request;
import org.mengsoft.webbackend.model.Category;
import org.mengsoft.webbackend.model.MenuItem;
import org.mengsoft.webbackend.model.User;
import org.mengsoft.webbackend.service.CategoryService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@RestController
@EnableAutoConfiguration
@Slf4j
public class CategoryController {

    @Resource
    private CategoryService categoryService;

    @RequestMapping(value="/category/getAllCategories", method= RequestMethod.POST, produces="application/json")
    public List<Category> getAllCategories(){

        return this.categoryService.getAllCategory();
    }

    @RequestMapping(value="/category/getCategoriesByBound", method= RequestMethod.POST, produces="application/json")
    public Map<String, Object> getCategoriesByBound(@RequestBody Request<Map<String, String>> param){

        return this.categoryService.getCategoriesByBound(param);
    }
}
