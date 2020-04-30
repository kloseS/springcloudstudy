package com.klose.eurekaclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Value("${a.name}")
    private String a_name;
    @Value("${b.name}")
    private String b_name;

    @RequestMapping("/getName")
    public String getPort() {
        return "a_name: " + a_name + "， b_name:" + b_name;
    }

}
