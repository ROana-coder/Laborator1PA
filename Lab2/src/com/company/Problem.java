package com.company;

import java.util.Objects;

public class Problem {

    int[][] costs;


    int[] Supply = new int[100];
    int[] Demand = new int[100];

    //constructor
    public Problem(int n, int m)
    {
        costs= new int[n][m];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                this.costs[i][j] = 0;

    }
    //setter
    public void setCosts(int n, int m, int value) {
        this.costs[n][m] = value;
    }
    //getter
    public int[][] getCosts() {
        return costs;
    }
}
