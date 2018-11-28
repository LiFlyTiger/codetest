package com.lifeihu.spring.cloud.weather.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by e-lifeihu on 2018/10/22.
 */
@RestController
public class HelloController {
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String say(){
        return "HELLO TIGER";
    }




    //如何提交111
    //如何提交222
    //如何提交333
}
