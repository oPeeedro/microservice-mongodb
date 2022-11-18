package com.microservice.inventoryservice.service;

import com.microservice.inventoryservice.model.Inventory;
import com.microservice.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryService {

    public final InventoryRepository inventoryRepository;

    public List<Inventory> findAllByRestaurantId(String RestaurantId){
        return inventoryRepository.findAllByRestaurantId(RestaurantId);
    }

    public void createMenuItems(Inventory menuItem) {inventoryRepository.save(menuItem);}

    public void uploadMenuItems(List<Inventory> ItemList) {
      //inventoryRepository.save(ItemList);
    }
}
