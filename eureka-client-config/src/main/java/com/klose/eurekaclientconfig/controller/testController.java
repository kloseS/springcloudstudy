package com.klose.eurekaclientconfig.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController {

    @Value("${name}")
    private String name;

    @RequestMapping("/getName")
    public String getName(){
        return name;
    }

}
