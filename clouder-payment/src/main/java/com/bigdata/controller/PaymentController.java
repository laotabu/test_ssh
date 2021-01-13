package com.bigdata.controller;

import com.bigdata.pojo.CommonResult;
import com.bigdata.pojo.Payment;
import com.bigdata.sevice.PaymentService;
import com.bigdata.sevice.impl.PaymentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class PaymentController {

    @Resource
    private PaymentServiceImpl paymentServiceImpl;

    @PostMapping("/payment/create")
    public CommonResult create(Payment payment){
        int result = paymentServiceImpl.create(payment);
        System.out.println(result);
        if(result>0){
            return new CommonResult(200,"插入成功",result);
        }else{
            return new CommonResult(444,"插入失败",null);
        }
    }
    @GetMapping("/payment/select/{id}")
    public CommonResult getPaymentById(@PathVariable("id") int id){
        System.out.println("Controller层： id = " + id);
        Payment payment = paymentServiceImpl.getPaymentById(id);
        System.out.println(payment);
        if (payment != null){
            return new CommonResult(200,"查询成功",payment);
        }else {
            return new CommonResult(444,"查询失败",null);
        }
    }
}
