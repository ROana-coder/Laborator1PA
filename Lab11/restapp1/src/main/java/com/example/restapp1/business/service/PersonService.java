package com.example.restapp1.business.service;

import com.example.restapp1.data.entity.Person;
import com.example.restapp1.data.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getPersons(){
        Iterable<Person> persons = this.personRepository.findAll();
        return (List<Person>) persons;
    }

    public Optional<Person> findById(int id)
    {
        return personRepository.findById((long) id);
    }

    public Iterable<Person> findAll()
    {
        return personRepository.findAll();
    }

    public Person save(Person person) {
        personRepository.save(person);
        return person;
    }

    public void remove(long id) {
        personRepository.deleteById(id);
    }

    public Person update(Person newPerson, long id) {
        return personRepository.findById(id)
                .map(person -> {
                    person.setPersonName(newPerson.getPersonName());
                    person.setPersonAge(newPerson.getPersonAge());
                    return personRepository.save(person);
                })
                .orElseGet(() -> {
                    newPerson.setPersonId(id);
                    return personRepository.save(newPerson);
                });
    }
}
