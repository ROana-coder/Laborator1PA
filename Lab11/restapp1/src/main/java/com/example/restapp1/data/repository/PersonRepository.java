package com.example.restapp1.data.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.restapp1.data.entity.Person;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {


}
