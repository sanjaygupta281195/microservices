package com.example.microservice1.Repo;

import com.example.microservice1.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepo extends JpaRepository<Person,String> {
}
