package com.caimao.information.controller;

import com.caimao.information.entity.SortEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *  RestController == @Controller + 每个方法 @ResponseBody
 * @author: genx
 * @date: 2018/12/13 17:25
 */
@RestController
@RequestMapping("/index")
public class IndexController {


    @RequestMapping("/hello")
    public String hello() {
        return "this is IndexController#hello";
    }

    @RequestMapping("/getSort")
    public SortEntity getSort() {
        SortEntity sortEntity = new SortEntity();
        sortEntity.setSortName("热门");
        return sortEntity;
    }

    @RequestMapping("/exception")
    public String exception() {
        int a = 0;
        int b = 0;
        return String.valueOf(a / b);
    }
}
