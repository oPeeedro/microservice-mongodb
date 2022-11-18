package com.microservice.inventoryservice.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.UUID;

@RequiredArgsConstructor(onConstructor = @__(@PersistenceConstructor))
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Inventory {
    @Id
    String id;

    private String restaurantId;
    private String name;
    private String description;
    private int price;
}
