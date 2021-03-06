package com.linkus.springcloud;

import com.linkus.rule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * 预定模块
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name="CLOUD-PROVIDER-SERVICE", configuration = MySelfRule.class)
public class OrderMain80 {
    public static void main(String[] args) {
        System.out.println("brgin--");
        SpringApplication.run(OrderMain80.class,args);
    }
}
