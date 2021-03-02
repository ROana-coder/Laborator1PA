package com.company;

import java.util.Objects;
/**
 * sursele
 * */
abstract class Source {

    private String name;
    private int capacity; //how many units of a commodity it is able to supply to the destinations
    /*aceasta linie a fost stearsa pentru a transforma clasa intr-una abstracta
    *private Main.SourceType type;
     */
    //constructors
    /**
     * initializeaza numele Sursei ca fiind by default S
     * iar capacitatea 0
     * */
    public Source()
    {
        name = "S";
        capacity = 0;
        //type = null;
    }
    public Source(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        //this.type = type;
    }
    //setters
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public void setName(String name) {
        this.name = name;
    }
    /*
    *public void setType(Main.SourceType type) {
    *    this.type = type;
    *}
*/
    //getters
    /**
     * returneaza capacitatea sursei
     * */
    public int getCapacity() {
        return capacity;
    }
    /**
     * returneaza tipul sursei
     * */
    public String getType() {
        return "SOURCE";
   }
    /**
     * returneaza numele sursei
     * */
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Source source = (Source) o;
        return capacity == source.capacity && Objects.equals(name, source.name);
    }

}
