package com.linkus.springcloud.controller;

import com.linkus.springcloud.entities.CommonResult;
import com.linkus.springcloud.entities.Payment;
import com.linkus.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("插入结果:{},端口:{}",payment,port);

        if (result>0){
            return new CommonResult(200,"插入成功",result);
        }else{
            return new CommonResult(444,"插入失败",result);
        }
    }
    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询结果:{},端口:{}",payment,port);

        if (null != payment){
            return new CommonResult(200,"查询成功,端口"+port,payment);
        }else{
            return new CommonResult(444,"查询无记录,id:"+id+",端口\"+port",null);
        }
    }
    @GetMapping("/payment/discovery")
    public Object discovery(){
        List<String> list = discoveryClient.getServices();
        for (String str : list){
            log.info(str);
        }
        List<ServiceInstance> instanceList = discoveryClient.getInstances("CLOUD-PROVIDER-SERVICE");
        for(ServiceInstance instance : instanceList){
            log.info("{},{},{},{},{}",instance.getServiceId(),instance.getHost(),instance.getPort(),instance.getUri(),instance.getInstanceId());
        }
        return this.discoveryClient;
    }
}
