package com.microservice.inventoryservice.repository;

import com.microservice.inventoryservice.model.Inventory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InventoryRepository extends MongoRepository<Inventory, String> {
    List<Inventory> findAllByRestaurantId(@Param("restaurantId") String restaurantId);
}
