package com.linkus.springcloud.controller;

import com.linkus.springcloud.OrderFeignHystrixMain80;
import com.linkus.springcloud.entities.CommonResult;
import com.linkus.springcloud.entities.Payment;
import com.linkus.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_Fallbackmenthod")
public class OrderFeignHystrixController {
    @Resource
    private PaymentService paymentService;

    @GetMapping("/consumer/payment/hystrix/get/{id}")
    public String paymentInfo_ok(@PathVariable("id") Integer id){
        return paymentService.paymentInfo_ok(id);
    }

    /**
     * 超时
     * @param id
     * @return
     */
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
/*    @HystrixCommand(fallbackMethod = "paymentInfo_client_timeoutHandler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="1500")
    })*/
    @HystrixCommand
    public String paymentInfo_timeolut(@PathVariable("id") Integer id){
        //int i = 10/0;
        String result = paymentService.paymentInfo_timeolut(id);
        return result;
    }

    private String paymentInfo_client_timeoutHandler(Integer id){
        return "80客户端线程池:"+Thread.currentThread().getName()+"paymentInfo_client_timeoutHandler,id:"+id+"o(╥﹏╥)大哭";
    }

    //下面是全局fallback
    public String payment_Global_Fallbackmenthod(){
        return "这是全局fallback(꒦_꒦)Global ";
    }
}
