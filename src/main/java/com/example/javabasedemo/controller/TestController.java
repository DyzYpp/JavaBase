package com.example.javabasedemo.controller;

import com.example.javabasedemo.pojo.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 86187
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Value("${timeout}")
    private Long timeOut;

    @Resource
    private User user;

    @GetMapping
    public Long test() {
        return timeOut;
    }

    @GetMapping("getUserName")
    public String getUserName(){
        return user.getUsername();
    }

    @GetMapping("getUserAge")
    public Integer getUserAge(){
        return user.getAge();
    }

}
