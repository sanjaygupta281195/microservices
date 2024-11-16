package com.example.microservice1.Entity;


import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;


@Data
@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name  = "id")
    private UUID id;

    @Column(name= "order_id")
    private String orderId;

    @Column(name = "order_Date")
    private Date orderdate;

    @Column(name = "order_amt")
    private BigDecimal orderAmt;


    @ManyToOne
    @JoinColumn(name = "person_id",referencedColumnName = "id",nullable = false)
    private Person person;
}
