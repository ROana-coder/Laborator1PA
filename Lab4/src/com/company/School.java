package com.company;
import java.util.Objects;

public class School implements Comparable {
    private String name;
    private int capacity;
    private String[] preferences = new String[capacity];
    private int number_of_students;

    public void decrementCapacity()
    {
        capacity--;
    }
    public School(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String[] getPreferences() {
        return preferences;
    }

    public void setPreferences(String[] preferences) {
        this.preferences = preferences;
    }

    public int getNumber_of_students() {
        return number_of_students;
    }

    @Override
    public String toString() {
        return name;
    }

    public void setNumber_of_students(int number_of_students) {
        this.number_of_students = number_of_students;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        School school = (School) o;
        return name.equals(school.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public int compareTo(Object o) {

        School school = (School) o;
        return this.getName().compareTo(school.getName());
    }

    //@Override
    /*public int compareTo(School o) {
        if (this.getName() < o.getName()) {
                    return -1;
                 } else if (this.getName() > o.getName()) {
                     return 1;
                 } else return 0;
        return 0;
    }*/
    // public int compareTo(Objects o) {
    //     if (this.getName() < o.getName()) {
    //         return -1;
    //     } else if (this.getName() > o.getName()) {
    //         return 1;
    //     } else return 0;
    // }

}
