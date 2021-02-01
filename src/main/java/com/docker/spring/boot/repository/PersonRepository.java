package com.docker.spring.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.docker.spring.boot.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long>{
    
}