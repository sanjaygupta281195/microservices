package com.example.microservice1.Controller;


import com.example.microservice1.Exception.ResourceNotFound;
import com.example.microservice1.Model.PersonDetails;
import com.example.microservice1.Model.PersonOrderDetails;
import com.example.microservice1.ServiceImp.ServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class Controller {

    @Autowired
    ServiceImp serviceImp;

    @PostMapping(value = "/addOrder")
    private ResponseEntity<PersonOrderDetails> addOrder(@RequestBody PersonOrderDetails personOrderDetails) {
        PersonOrderDetails p = serviceImp.addPersonDetails(personOrderDetails);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @GetMapping(value = "/getPersonDetails")
    private ResponseEntity<PersonDetails>getPersonDetails(@RequestParam String personId) throws ResourceNotFound {
        PersonDetails p = serviceImp.getPersonDetails(personId);
        return new ResponseEntity<PersonDetails>(p,HttpStatus.OK);

    }

    @GetMapping (value = "/getallperson")
    private List<PersonDetails> getAllPerson(){
        return serviceImp.getAllPersonDetails();
    }

}
