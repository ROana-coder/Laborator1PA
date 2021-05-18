package com.example.restapp1.data.entity;

import javax.persistence.*;

@Entity
@Table(name="PERSONS")
public class Person {
    public Person(long personId, String personName, int personAge) {
        this.personId = personId;
        this.personName = personName;
        this.personAge = personAge;
    }

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long personId;
    @Column(name="NAME")
    private String personName;
    @Column(name="AGE")
    private int personAge;

    private String password;
    public Person() {

    }

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public int getPersonAge() {
        return personAge;
    }

    public void setPersonAge(int personAge) {
        this.personAge = personAge;
    }

    public long getId() {
        return personId;
    }

    public void remove(Person person) {

    }
}
