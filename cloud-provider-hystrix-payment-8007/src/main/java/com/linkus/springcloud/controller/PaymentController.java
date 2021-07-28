package com.linkus.springcloud.controller;

import com.linkus.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 正常：http://localhost:8007/payment/circuit/timeout/18
 * 异常：http://localhost:8007/payment/circuit/timeout/-19
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private int port;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_ok(@PathVariable("id") Integer id){
        String result = paymentService.paymentInfoOK(id);
        log.info("*********result:{}",result);
        return result;
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_timeolut(@PathVariable("id") Integer id){
        String result = paymentService.paymentInfo_timeout(id);
        log.info("*********result:{}",result);
        return result;
    }

    @GetMapping("/payment/circuit/timeout/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        String result = paymentService.paymentCircuitBreaker(id);
        log.info("*********result:{}",result);
        return result;
    }
}
