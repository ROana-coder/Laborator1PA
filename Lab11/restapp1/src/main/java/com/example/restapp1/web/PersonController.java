package com.example.restapp1.web;

import com.example.restapp1.business.service.PersonService;
import com.example.restapp1.data.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PersonController {
    private final PersonService personService;
//private final PersonRepository personResRepository;

    private final List<Person> persons = new ArrayList<>();

    @Autowired
    public PersonController(PersonService personService)
    {
        this.personService = personService;
    }

    @GetMapping("/persons")
    public Iterable<Person> getPersonService() {
        //List<Person> persons =
        return personService.getPersons();
    }

    @GetMapping("/count")
    public int countPersons() {
        return persons.size();
    }
    @GetMapping("/person/{id}")
    public Optional<Person> getPerson(@PathVariable("id") int id) {
        return personService.findById(id);
    }



    @PostMapping(value = "/add", consumes="application/json")
    public Person createPersonInDB(@RequestBody Person person) {
        return personService.save(person);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateProduct(
            @PathVariable int id, @RequestBody Person person) {

        Optional<Person> person1 = personService.findById((int) id);
        personService.update(person, id);
        if (person1 == null) {
            throw new CustomNotFoundException("Not found customer with id " + id);
        }
        //person.setPersonName(name);
        return new ResponseEntity<>(
                "Product updated successsfully", HttpStatus.OK);
    }
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable long id) {
        Optional<Person> person = personService.findById((int) id);
        if (person.isEmpty()) {
            throw new CustomNotFoundException("Not found customer with id " + id);
        }
        personService.remove(id);
        return new ResponseEntity<>("Product removed", HttpStatus.OK);
    }


}
