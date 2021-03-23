package com.company;

public class ListCommand extends Command{
    public void list(Catalog catalog)
    {
        catalog.list();
    }
}
