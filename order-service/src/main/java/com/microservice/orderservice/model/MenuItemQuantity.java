package com.microservice.orderservice.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Document
public class MenuItemQuantity {
    @Id
    private String id;

    private String name;
    private int price;
    private int quantity;
}
