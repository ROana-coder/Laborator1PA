package com.company;


public class Main {
    /*
    *-stergem acest enum pentru a putea face clasa source abstracta
    *cu doua clase derivate din ea, fiecare avand tipul predefinit fie warehouse fie factory:
    *public enum SourceType {
     *   WAREHOUSE, FACTORY;
    }*/
    public static void main(String[] args) {

    //Source S1 = new Source("S1", 12, "SourceType.WAREHOUSE");
    //Source S2 = new Source("S2", 12, "SourceType.FACTORY");
    //Source S3 = new Source("S3", 12"SourceType.FACTORY");
    Problem problem = new Problem(3,3);
    int[][] costs= new int[3][3];
    costs[0][0] = 2;
    costs[0][1] = 3;
    costs[0][2] = 1;
    costs[1][0] = 5;
    costs[1][1] = 4;
    costs[1][2] = 8;
    costs[2][0] = 5;
    costs[2][1] = 6;
    costs[2][2] = 8;
    problem.setCosts(costs);

    Source[] supply = new Source[3];
    supply[0] = new Warehouse();
    supply[0].setCapacity(10);
    supply[0].setName("S1");

    supply[1] = new Factory();
    supply[1].setCapacity(35);
    supply[1].setName("S2");

    supply[2] = new Factory();
    supply[2].setCapacity(25);
    supply[2].setName("S3");
    problem.setSources(supply);

    /*Destination[] demand = new Destination[3];
    demand[0].setName("D1");
    demand[0].setCommodities(20);

    demand[1].setName("D2");
    demand[1].setCommodities(25);

    demand[2].setName("D3");
    demand[2].setCommodities(25);
    problem.setDestinations(demand);

    Solution solution = new Solution(problem);
    System.out.println(solution.getTotalCost());
*/
    }
}
