package com.bigdata.sevice;

import com.bigdata.pojo.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {
    public int create(Payment payment);
    public Payment getPaymentById(@Param("id") int id);
}
