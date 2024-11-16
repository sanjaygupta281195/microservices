package com.example.microservice1;

import com.example.microservice1.Entity.Orders;
import com.example.microservice1.Entity.Person;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.beans.ConstructorProperties;
import java.math.BigDecimal;
import java.util.List;


@Data
@AllArgsConstructor
public class PersonOrderDetails {
    private String fname;
    private String lname;
    private String city;
    private String orderId;
    private BigDecimal orderAmount;
}
