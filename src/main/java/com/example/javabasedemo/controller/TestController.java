package com.example.javabasedemo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 86187
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Value("${timeout}")
    private Long timeOut;

    @GetMapping
    public Long test() {
        return timeOut;
    }

}
