package com.microservice.orderservice.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Document
public class UserInfo {
    @Id
    private Integer id;

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;
}
