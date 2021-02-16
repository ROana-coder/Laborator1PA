package com.company;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello, world!");



        String[] languages = new String[]{"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};

        for (int i = 0; i < languages.length; i++)
            System.out.println(languages[i]);

        int n = (int) (Math.random() * 1_000_000);
        System.out.println(n);

        n = n * 3;
        System.out.println(n);

        int adauga10101 = Integer.parseInt("10101",2);
        n = n + adauga10101;
        System.out.println(n);

        int adaugaFF = Integer.parseInt("FF",16);
        n = n + adaugaFF;
        System.out.println(n);

        n = n * 6;
        System.out.println(n);


        while(n > 10)
        {
            int m = n;
            int s = 0;
            while(m>0)
            {
                s = s + (m%10);
                m = m/10;
            }
            n = s;
        }

        System.out.println(n);

        System.out.println("Willy-nilly, this semester I will learn " + languages[n]);

        //Optional

        String s = args[0];




    }
}
