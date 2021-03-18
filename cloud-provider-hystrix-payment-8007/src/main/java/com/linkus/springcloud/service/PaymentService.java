package com.linkus.springcloud.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
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
    public String paymentInfo_timeout(Integer id){
        int num = 3;
        try {
            TimeUnit.SECONDS.sleep(num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池:"+Thread.currentThread().getName()+"paymnetInfo_timeout,id:"+id+"(꒦_꒦) ，耗时"+num+"秒钟";
    }
}
