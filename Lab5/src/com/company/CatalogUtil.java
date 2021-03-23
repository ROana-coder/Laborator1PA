package com.company;

import java.awt.*;
import java.io.*;
import java.net.URI;

public class CatalogUtil {



    public static void save(Catalog catalog)
            throws IOException {

        try (var oos = new ObjectOutputStream(
                new FileOutputStream(catalog.getPath())
        )) {
            oos.writeObject(catalog);
        }

        System.out.println("Success save");
    }

    public static Catalog load(String path)
    {
        try {
            FileInputStream file = new FileInputStream(path);
            ObjectInputStream in = new ObjectInputStream(file);

            Catalog c = (Catalog) in.readObject();

            System.out.println("Success load");
            in.close();

            return c;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            System.out.println("Catalog class not found");
            e.printStackTrace();
            return null;
        }

    }

    public static void view(Catalog catalog) throws IOException {
        Desktop desktop = Desktop.getDesktop();
        desktop.browse(URI.create(catalog.getPath()));
        System.out.println("Success");
    }


}