package com.linkus.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 这是个服务注册中心，主要干的活就是服务注册，不需要写业务类。
 * 但是注意：Eureka有两个组件，一定要标清楚哪个是Server，哪个是Client。@EnableEurekaServer代表服务注册中心
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaMain7002 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7002.class,args);
    }

}
