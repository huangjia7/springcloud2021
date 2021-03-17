package com.linkus.springcloud.controller;

import com.linkus.springcloud.service.PaymentFeignService;
import com.linkus.springcloud.entities.CommonResult;
import com.linkus.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderFeignController {
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        log.info("---getPaymentById");
        return paymentFeignService.getPaymentById(id);
    }
    @GetMapping("/consumer/payment/timeout")
    public String timeout(){
        log.info("---timeout");
        return paymentFeignService.timeout();
    }
}
