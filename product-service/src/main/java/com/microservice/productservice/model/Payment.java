package com.microservice.productservice.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.microservice.productservice.model.CreditCardInfo;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Document
public class Payment {
    @Id
    String id;

    private long timestamp;
    private int amount;
    private String orderId;
    private CreditCardInfo creditCardInfo;


}
