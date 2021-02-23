package com.company;

public class Source {



    private String name;
    private int capacity; //how many units of a commodity it is able to supply to the destinations
    private Main.SourceType type;
    //constructors
    public Source()
    {
        name = null;
        capacity = 0;
        type = null;
    }
    public Source(String name, int capacity, Main.SourceType type) {
        this.name = name;
        this.capacity = capacity;
        this.type = type;
    }
    //setters
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setType(Main.SourceType type) {
        this.type = type;
    }

    //getters
    public int getCapacity() {
        return capacity;
    }
    public Main.SourceType getType() {
        return type;
    }
    public String getName() {
        return name;
    }
}
