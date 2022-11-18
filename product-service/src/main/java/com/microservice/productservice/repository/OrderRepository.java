package com.microservice.productservice.repository;

import com.microservice.productservice.model.Order;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends PagingAndSortingRepository<Order, String> {

    Order findOrderById(@Param("id") String id);

    Order save(@Param("order") Order order);
}
