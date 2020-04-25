package com.klose.eurekaclientconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EurekaClientConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientConfigApplication.class, args);
    }

}
