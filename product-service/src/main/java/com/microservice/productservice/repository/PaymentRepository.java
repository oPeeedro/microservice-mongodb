package com.microservice.productservice.repository;

import com.microservice.productservice.model.Payment;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends PagingAndSortingRepository<Payment, String> {

    Payment findPaymentById(@Param("id") String id);
}
