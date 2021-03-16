package com.company;

import java.util.Arrays;

public class Student {


    private String name;
    private String[] preferences = new String[20];
    private int number_of_preferences = 0;

    public Student(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String[] getPreferences() {
        return preferences;
    }

    public void setPreferences(String[] preferences) {
        this.preferences = preferences;
    }

    @Override
    public String toString() {
        return name;
    }

    public void addPreferences(String school_name) {
        preferences[number_of_preferences] = school_name;
        number_of_preferences++;
    }
}
