package com.microservice.orderservice.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

/*@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor*/
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@Data
@Document
public class Order {

    @Id
    private String id;

    //@Embedded
    private List<MenuItemQuantity> menuItemList;

    //@Embedded
    private UserInfo userInfo;

    private String restaurantId;
    private int totalPrice;
    private long orderTime;
    private String specialNote;
    private long deliveryTime;
    private String paymentId;
}
