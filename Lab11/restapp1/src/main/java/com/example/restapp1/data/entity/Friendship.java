package com.example.restapp1.data.entity;

import javax.persistence.*;

@Entity
@Table(name="FRIENDS")
public class Friendship {

    @Column(name="NAME1")
    private String name1;

    @Column(name="NAME2")
    private String name2;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Friendship() {
    }

    public Friendship(String name1, String name2) {
        this.name1 = name1;
        this.name2 = name2;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
