package com.linkus.springcloud.controller;

import com.linkus.springcloud.OrderFeignHystrixMain80;
import com.linkus.springcloud.entities.CommonResult;
import com.linkus.springcloud.entities.Payment;
import com.linkus.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderFeignHystrixController {
    @Resource
    private PaymentService paymentService;

    @GetMapping("/consumer/payment/hystrix/get/{id}")
    public String paymentInfo_ok(@PathVariable("id") Integer id){
        return paymentService.paymentInfo_ok(id);
    }
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    public String paymentInfo_timeolut(@PathVariable("id") Integer id){
        return paymentService.paymentInfo_timeolut(id);
    }
}
