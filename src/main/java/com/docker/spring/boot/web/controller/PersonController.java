package com.docker.spring.boot.web.controller;

import java.util.List;

import com.docker.spring.boot.entity.Person;
import com.docker.spring.boot.repository.PersonRepository;
import com.docker.spring.boot.web.bean.PersonDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PersonController {
    
    @Autowired
    private PersonRepository personRepository;

    @CrossOrigin(origins = "http://localhost:5000")
    @GetMapping("/person")
    public List<Person> getPersons(){
        return personRepository.findAll();
    }

    @CrossOrigin(origins = "http://localhost:5000")
    @PostMapping("/person/add")
    public ResponseEntity<Person> addPerson(@RequestBody PersonDTO personDTO) {
        try {
            Person entity = new Person();
            entity.setName(personDTO.getName());
            personRepository.save(entity);
            return new ResponseEntity<Person>(entity, new HttpHeaders(), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<Person>(null, new HttpHeaders(), HttpStatus.BAD_GATEWAY);

        }
    }
    
    
}
