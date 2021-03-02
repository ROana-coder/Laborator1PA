package com.company;

import java.util.Objects;
/**
 * Problema
 * */
public class Problem {


    int[][] costs;
    Source[] sources = new Source[100];
    Destination[] destinations = new Destination[100];

    //constructor
    /**
     * Acest constructor va initializa matricea de costuri cu 0
     * */
    public Problem(int n, int m)
    {
        costs= new int[n][m];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                this.costs[i][j] = 0;

    }
    /**
     * Constructor ce primeste ca parametru in obiect de tip Problem
     * */
    public Problem(int[][] costs) {
        this.costs = costs;
    }
    //setter
    /**
     * Setter: primeste ca parametru un vector  cu obieste de tip Source si schimba valorile din sources cu cele primite prin acel parametru
     * */
    public void setSources(Source[] sources) {
        this.sources = sources;
    }
    /**
     * seteaza costurile problemei
     * */
    public void setCosts(int[][] costs) {
        this.costs = costs;
    }
    /**
     * seteaza destinatiile problemei
     * */
    public void setDestinations(Destination[] destinations) {
        this.destinations = destinations;
    }
    //getter
    /**
     * returneaza un vector de obiecte de tipul Destination
     * */
    public Destination[] getDestinations() {
        return destinations;
    }
    /**
     * returneaza un vector de obiecte de tipul Source
     * */
    public Source[] getSources() {
        return sources;
    }
    /**
     * returneaza un o matrice cu costurile problemei
     * */
    public int[][] getCosts() {
        return costs;
    }
}
