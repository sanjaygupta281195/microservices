package com.example.microservice1.Repo;

import com.example.microservice1.Entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrdersRepo extends JpaRepository<Orders, UUID> {
}
