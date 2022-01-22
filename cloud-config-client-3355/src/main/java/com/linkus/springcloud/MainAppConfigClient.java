package com.linkus.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MainAppConfigClient {
    public static void main(String[] args) {
        SpringApplication.run(MainAppConfigClient.class,args);
    }
}
