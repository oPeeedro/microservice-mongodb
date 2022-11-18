package com.microservice.inventoryservice.repository;


import com.microservice.inventoryservice.model.Restaurant;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

public interface RestaurantRepository extends MongoRepository<Restaurant, String> {

    public Restaurant findFirstByName(@Param("name") String name);
}
