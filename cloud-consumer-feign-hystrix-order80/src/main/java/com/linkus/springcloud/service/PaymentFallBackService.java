package com.linkus.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallBackService implements  PaymentService{
    @Override
    public String paymentInfo_ok(Integer id) {
        return "PaymentFallBackService fallback-paymentInfo_ok";
    }

    @Override
    public String paymentInfo_timeolut(Integer id) {
        return "PaymentFallBackService fallback-paymentInfo_timeolut";
    }
}
