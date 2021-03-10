package com.linkus.springcloud.controller;

import com.linkus.springcloud.entities.CommonResult;
import com.linkus.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Slf4j
@RestController
public class OrderZkController {
    private static final String PAYMENT_URL="http://cloud-provider-zookeeper-service";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/zk")
    public String zk(Payment payment) {
        return restTemplate.getForObject(PAYMENT_URL+"/payment/zk",String.class);
    }
}
