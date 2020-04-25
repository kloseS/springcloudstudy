package com.klose.customfeign.service;

import org.springframework.stereotype.Component;

@Component
public class ErrorClass implements HelloService {

    @Override
    public String getPort(String name) {
        return "null error";
    }
}
