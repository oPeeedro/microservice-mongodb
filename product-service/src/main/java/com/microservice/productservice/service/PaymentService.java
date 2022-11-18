package com.microservice.productservice.service;


import com.microservice.productservice.model.Payment;

public interface PaymentService {
    void processPayment(Payment payment);
}
