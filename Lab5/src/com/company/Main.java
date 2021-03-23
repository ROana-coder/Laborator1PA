package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static class JavaStringHistory
    {
        private final String[] history = new String[4];
    }
        public static void main(String args[]) throws IOException, InvalidCatalogException {
            Main app = new Main();
            app.testCreateSave();
            app.testLoadView();
            Catalog catalog = new Catalog("", "F:\\Lab5.1\\src\\com\\out.txt");
            String commandLine;
            BufferedReader console = new BufferedReader
                    (new InputStreamReader(System.in));


            //Break with Ctrl+C
            while (true) {

                System.out.print("shell>");
                commandLine = console.readLine();
                if (commandLine.equals(""))
                    continue;

                if (commandLine.equals("help"))
                {
                    System.out.println();
                    System.out.println();
                    System.out.println("Welcome to the shell");
                    System.out.println();
                    System.out.println("Commands to use:");
                    System.out.println("1) add");
                    System.out.println("2) list");
                    System.out.println("3) load");
                    System.out.println("4) play");
                    System.out.println("5) exit");
                    System.out.println("6) clear");
                    System.out.println();
                    System.out.println("---------------------");
                    System.out.println();
                }

                else if (commandLine.equals("clear"))
                {

                    for ( int cls = 0; cls < 15; cls++ )
                    {
                        System.out.println("");
                    }


                }

                else if (commandLine.equals("add"))
                {

                    System.out.println("book or song?");
                    String getItem = console.readLine();
                    if(getItem.equals("book"))
                    {
                        AddCommand addCommand = new AddCommand();
                        Book newBook = new Book();
                        System.out.println("Book name is:");
                        getItem = console.readLine();
                        newBook.setName(getItem);
                        System.out.println("Book id is:");
                        getItem = console.readLine();
                        newBook.setId(getItem);
                        System.out.println("Book path is:");
                        getItem = console.readLine();
                        newBook.setLocation(getItem);
                        addCommand.add(catalog, newBook);
                        System.out.println("Book added");
                    }
                    if(getItem.equals("song"))
                    {
                        AddCommand addCommand = new AddCommand();
                        Song newSong = new Song();
                        System.out.println("Song name is:");
                        getItem = console.readLine();
                        newSong.setName(getItem);
                        System.out.println("Book id is:");
                        getItem = console.readLine();
                        newSong.setId(getItem);
                        System.out.println("Book path is:");
                        getItem = console.readLine();
                        newSong.setLocation(getItem);
                        addCommand.add(catalog, newSong);
                        System.out.println("Song added");
                    }
                }
                else if (commandLine.equals("list"))
                {
                    ListCommand listCommand = new ListCommand();
                    listCommand.list(catalog);
                }
                else if (commandLine.equals("load"))
                {
                    LoadCommand loadCommand = new LoadCommand();
                    System.out.println("path:");
                    loadCommand.load(catalog, console.readLine());
                }
                else if (commandLine.equals("play"))
                {
                    PlayCommand playCommand = new PlayCommand();
                    playCommand.play(catalog);

                }
                else if (commandLine.equals("exit"))
                {
                    System.out.println("...Terminating the Virtual Machine");
                    System.exit(0);
                }

                else
                {
                    System.out.println("Inexistent command");
                    System.out.println("Commands to use:");
                    System.out.println("1) add");
                    System.out.println("2) list");
                    System.out.println("3) load");
                    System.out.println("4) play");
                    System.out.println("5) exit");
                    System.out.println("6) clear");
                    System.out.println();
                }

            }
        }

        private void testCreateSave() throws IOException {
            Catalog catalog = new Catalog("My Books", "F:\\Lab5.1\\src\\com\\out.txt");
            var song = new Song("bestSong", "" );
            var book = new Book("bestBook", "" );
            catalog.add(song);
            catalog.add(book);

            CatalogUtil.save(catalog);
        }

        private void testLoadView() throws InvalidCatalogException, IOException {

            Catalog catalog = CatalogUtil.load("F:\\Lab5.1\\src\\com\\out.txt");
            catalog.list();
            //CatalogUtil.view(catalog.findById("bestSong"));
        }
}
