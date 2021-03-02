package com.company;

import java.util.Objects;
/**
 * destinatiile
 * */
public class Destination {

    private String name;
    private int commodities;

    //constructors
    /**
     * initializeaza numele destinatiei ca fiind by default D
     * iar comoditatile 0
     * */
    public Destination()
    {
        this.name = "D";
        this.commodities = 0;
    }

    public Destination(String name) {
        this.name = name;
    }
    public Destination( int commodities)
    {
        this.commodities = commodities;
    }
    //setters
    /**
     * seteaza numarul de comi=oditati ale destinatiei
     * */
    public void setCommodities(int commodities) {
        this.commodities = commodities;
    }
    /**
     * seteaza numele destinatiei
     * */
    public void setName(String name) {
        this.name = name;
    }
    //getters
    /**
     * returneaza numarul de comoditati
     * */
    public int getCommodities() {
        return commodities;
    }
    /**
     * returneaza numee destinatiei
     * */
    public String getName() {
        return name;
    }

   @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Destination that = (Destination) o;
        return commodities == that.commodities && Objects.equals(name, that.name);
    }

}