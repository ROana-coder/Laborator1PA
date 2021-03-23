package com.company;

public class AddCommand extends Command{
    public void add(Catalog catalog, Item item)
    {
        catalog.add(item);
    }
}
