package com.klose.customfeign.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "eureka-client",fallback = ErrorClass.class)
public interface HelloService {

    @RequestMapping("hi")
    String getPort(@RequestParam String name);
}
