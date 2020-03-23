package com.infocity.controller;

import com.infocity.vo.Users;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liaoqiangang
 * @date 2020/3/22 11:00 PM
 * @desc
 * @lastModifier
 * @lastModifyTime
 **/
@RestController
@RequestMapping("users")
public class UserController {


    @RequestMapping("/get/{name}")
    @HystrixCommand
    public Object get(@PathVariable("name")String name){
        Users users = new Users();
        users.setName(name);
        users.setAge(18);
        users.setSex("F");
        return users;
    }
}
