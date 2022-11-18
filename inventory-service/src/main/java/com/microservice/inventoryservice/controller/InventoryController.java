package com.microservice.inventoryservice.controller;

import com.microservice.inventoryservice.model.Inventory;
import com.microservice.inventoryservice.model.Restaurant;
import com.microservice.inventoryservice.service.InventoryService;
import com.microservice.inventoryservice.service.RestaurantService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
@RequiredArgsConstructor
@AllArgsConstructor
public class InventoryController {
    private RestaurantService restaurantService;
    private InventoryService menuItemService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public void createRestaurant(@RequestBody Restaurant restaurant){
        restaurantService.createRestaurant(restaurant);
    }

    @GetMapping
    public Restaurant findRestaurantByName(@RequestParam(value = "name") String name){
        return restaurantService.getRestaurantByName(name);

    }
    @GetMapping(value = "/{restaurantsId}/menuItems")
    public List<Inventory> findAllMenuByRestaurantId(@PathVariable String restaurantsId){
        return menuItemService.findAllByRestaurantId(restaurantsId);
    }

    @PostMapping(value = "/menuItems")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void createMenuItem(@RequestBody Inventory menuItem){
        menuItemService.createMenuItems(menuItem);
    }

    @PostMapping(value = "/menuItems/upload")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void uploadMenuItems(@RequestBody List<Inventory> menuItemList){
        menuItemService.uploadMenuItems(menuItemList);
    }
}
