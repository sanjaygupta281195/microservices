package com.example.microservice1;


import com.example.microservice1.Entity.Orders;
import com.example.microservice1.Entity.Person;
import com.example.microservice1.Repo.OrdersRepo;
import com.example.microservice1.Repo.PersonRepo;
import com.example.microservice1.ServiceImp.ServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/person")
public class Controller {

    @Autowired
    ServiceImp serviceImp;

    @PostMapping(value = "/addOrder")
    private ResponseEntity<PersonOrderDetails> addOrder(@RequestBody PersonOrderDetails personOrderDetails){
       PersonOrderDetails p =  serviceImp.addPersonDetails(personOrderDetails);
        return new ResponseEntity<>(p,HttpStatus.OK);
    }

    @GetMapping(value = "/getPerson")
    private String getPersonDetails(){
        return "Hello";

    }
}
