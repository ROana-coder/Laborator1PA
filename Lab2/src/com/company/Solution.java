package com.company;

/**
 *Aceasta clasa va calcula costul minim avand ca atibut o problema de tip Problem
 *cu toate datele necesare rezolvarii problemei de transport
 *
        */
public class Solution {

    private Problem problem;

    //constructor
    /**
     * Constructor ce primeste ca parametru un obiect de tip Problema creat cu code generation
     * */
    public Solution(Problem problem) {
        this.problem = problem;
    }
    //setter
    /**
     * Setter ce primeste ca parametru un obiect de tip Problema creat cu code generation
     * */
    public void setProblem(Problem problem) {
        this.problem = problem;
    }
    //getter
    /**
     * Getter ce returneaza un obiect de tip Problem
     * */
    public Problem getProblem() {
        return problem;
    }
    /**
     * Functie ce calculeaza Costul total minim
     *
     * @totalCost va contine solutia ce va fi returnata
     * @costs este o matrice in care vom retine matricea de unitati a problemei
     * @supply un vector in care se retin obieste de tip Source, a caror capacitati vor fi folosite in calcularea rezultatului
     * @demand un vector ce retine destinatiile problemei
     * */
    public int getTotalCost()
    {
        int totalCost = 0;
        int[][] costs = new int[3][3];
        Source[] supply = new Source[3];
        Destination[] demand = new Destination[3];

        costs = problem.getCosts();
        supply = problem.getSources();
        demand = problem.getDestinations();

        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++)
                if(!(costs[i][j] * supply[i].getCapacity() > demand[i].getCommodities()))
                    totalCost += costs[i][j] * supply[i].getCapacity();
        return totalCost;
    }

}
