package com.linkus.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class PaymentService {

    /**
     * 正常返回
     * @param id
     * @return
     */
    public String paymentInfoOK(Integer id){
        return "线程池:"+Thread.currentThread().getName()+"paymnetInfo_OK,id:"+id+"^_^";
    }

    /**
     * 报错
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_timeoutHandler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="3000")
    })
    public String paymentInfo_timeout(Integer id){
        int num = 2;
        //int age=10/0;
        try {
            TimeUnit.SECONDS.sleep(num);
        } catch (InterruptedException e) {
            log.info(e.getMessage(),e);
        }
        return "线程池:"+Thread.currentThread().getName()+"paymnetInfo_timeout,id:"+id+"O(∩_∩)O哈哈~，耗时"+num+"秒钟";
    }

    private String paymentInfo_timeoutHandler(Integer id){
        return "8007服务端线程池:"+Thread.currentThread().getName()+"paymentInfo_timeoutHandler,id:"+id+"o(╥﹏╥)大哭";
    }
}
