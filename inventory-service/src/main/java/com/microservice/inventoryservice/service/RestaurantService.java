package com.microservice.inventoryservice.service;

import com.microservice.inventoryservice.model.Restaurant;
import com.microservice.inventoryservice.repository.RestaurantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public void createRestaurant(Restaurant restaurant) {
        restaurantRepository.save(restaurant);
    }

    public Restaurant getRestaurantByName(String name) {
        return restaurantRepository.findFirstByName(name);
    }
}
