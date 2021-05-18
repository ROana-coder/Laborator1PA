package com.example.restapp1;

import com.example.restapp1.data.entity.Person;
import com.example.restapp1.data.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class  Restapp1Application {

    public static void main(String[] args) {
        SpringApplication.run(Restapp1Application.class, args);
    }

//    @RestController
//    public class PersonController{
//        @Autowired
//        private PersonRepository personRepository;
//
////        @GetMapping
////        public  Iterable<Person> getPersons(){
////            return this.personRepository.findAll();
////        }
//    }
}
