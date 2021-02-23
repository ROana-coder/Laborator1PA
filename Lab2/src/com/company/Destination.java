package com.company;

public class Destination {

    private String name;
    private int commodities;

    //constructors
    public Destination()
    {
        name = null;
        commodities = 0;
    }
    public Destination(String name, int commodities)
    {
        this.name = name;
        this.commodities = commodities;
    }
    //setters
    public void setCommodities(int commodities) {
        this.commodities = commodities;
    }
    public void setName(String name) {
        this.name = name;
    }
    //getters
    public int getCommodities() {
        return commodities;
    }
    public String getName() {
        return name;
    }
}