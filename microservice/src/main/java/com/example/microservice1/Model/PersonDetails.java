package com.example.microservice1.Model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class PersonDetails {

    private String fname;
    private String lname;
    private String personId;
    private String city;
}
