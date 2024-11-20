package com.example.microservice1.Entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name ="person_details" )
public class Person {

    @Id
    @Column(name = "person_id")
    private String personId;

    @Column(name = "first_name")
    private String name;

    @Column(name = "last_Name")
    private String lastName;

    @Column(name  = "city")
    private String city;

    @OneToMany(mappedBy = "person",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Orders> order;
}
