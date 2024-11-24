package com.example.microservice2.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;


@Data
@AllArgsConstructor
public class PersonOrderDetails {
    private String fname;
    private String lname;
    private String personId;
    private String city;
    private BigDecimal orderAmount;
}
