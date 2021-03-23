package com.company;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Catalog implements Serializable {
    private String name;
    private String path;
    private List<Item> items = new ArrayList<>();

    public Catalog(String my_books, String s) {
        this.name = my_books;
        this.path = s;
    }

    public void list()
    {
        for (Item item: items) {
            System.out.println(item.getName());
        }
    }
    public void play () throws IOException {
        Desktop.getDesktop().open(new File(path));
        System.out.println("Success");
    }

    public Item findById(String id) throws InvalidCatalogException{

        return items.stream()
                .filter(d -> d.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Catalog catalog = (Catalog) o;
        return Objects.equals(name, catalog.name) && Objects.equals(path, catalog.path) && Objects.equals(items, catalog.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, path, items);
    }

    public String getPath() {
        return path;
    }

    public void add(Item item) {
        items.add(item);
    }
}

