package com.microservice.inventoryservice.repository;

import com.google.common.base.Optional;
import com.microservice.inventoryservice.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface InventoryRepository extends JpaRepository<Inventory, UUID> {
    List<Inventory> findByIdIn(List<String> id);
}
