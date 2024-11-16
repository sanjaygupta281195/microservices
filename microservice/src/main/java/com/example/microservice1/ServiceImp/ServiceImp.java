package com.example.microservice1.ServiceImp;


import com.example.microservice1.Entity.Orders;
import com.example.microservice1.Entity.Person;
import com.example.microservice1.PersonOrderDetails;
import com.example.microservice1.Repo.OrdersRepo;
import com.example.microservice1.Repo.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ServiceImp {

    @Autowired
    PersonRepo personRepo;

    @Autowired
    OrdersRepo ordersRepo;

    public PersonOrderDetails addPersonDetails(PersonOrderDetails personOrderDetails){

        Person p = new Person();
        p.setLastName(personOrderDetails.getLname());
        p.setName(personOrderDetails.getFname());
        p.setCity(personOrderDetails.getCity());

        personRepo.save(p);

        Orders o = new Orders();
        o.setOrderdate(new Date());
        o.setOrderId(personOrderDetails.getOrderId());
        o.setOrderAmt(personOrderDetails.getOrderAmount());
        o.setPerson(p);

        ordersRepo.save(o);

        return personOrderDetails;

    }
}
