package com.example.microservice2.PersonController;


import com.example.microservice2.ServiceImp.PersonServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @Autowired
    PersonServiceImp personServiceImp;

    @PostMapping
    public String addUser(){
        personServiceImp.adduser();
        return "";
    }
}
