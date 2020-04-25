package com.klose.customribbon.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/hello")
    @HystrixCommand(fallbackMethod = "obtainFailure")
    public String getPort(String name){
        return restTemplate.getForObject("http://eureka-client/hi?name="+name,String.class);
    }

    private String obtainFailure(String name){
        return "sorry "+name+", server error";
    }
}
