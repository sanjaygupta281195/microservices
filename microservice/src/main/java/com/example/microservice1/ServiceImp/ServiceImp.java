package com.example.microservice1.ServiceImp;


import com.example.microservice1.Entity.Orders;
import com.example.microservice1.Entity.Person;
import com.example.microservice1.Model.PersonDetails;
import com.example.microservice1.Model.PersonOrderDetails;
import com.example.microservice1.Repo.OrdersRepo;
import com.example.microservice1.Repo.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
        p.setPersonId(personOrderDetails.getPersonId());

        personRepo.save(p);

        Orders o = new Orders();
        o.setOrderdate(new Date());
        o.setOrderAmt(personOrderDetails.getOrderAmount());
        o.setPerson(p);

        ordersRepo.save(o);

        return personOrderDetails;

    }

    public String getPersonDetails(String personId) {

        Optional<Person> personDb = personRepo.findById(personId);
        PersonDetails personDetails;
        if (!personDb.isEmpty()) {
            personDetails = PersonDetails.builder()
                    .fname(personDb.get().getName())
                    .lname(personDb.get().getLastName())
                    .city(personDb.get().getCity())
                    .personId(personDb.get().getPersonId())
                    .build();
        }
        else return personId + " not found";
        return String.valueOf(personDetails);
    }

    public List<PersonDetails> getAllPersonDetails() {
        List<Person> personList = personRepo.findAll();
        List<PersonDetails> allPersonDetails = new ArrayList<>();

        for(Person i : personList){
            PersonDetails p  =  PersonDetails.builder()
                    .personId(i.getPersonId())
                    .city(i.getCity())
                    .lname(i.getLastName())
                    .fname(i.getName())
                    .build();
            allPersonDetails.add(p);
        }
        return allPersonDetails;
    }
}
