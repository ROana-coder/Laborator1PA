package com.company;


public class Main {
    public enum SourceType {
        WAREHOUSE, FACTORY;
    }
    public static void main(String[] args) {
    Source S1 = new Source("S1", 12, SourceType.FACTORY);
    Source S2 = new Source("S2", 12, SourceType.WAREHOUSE);
    Source S3 = new Source("S3", 12, SourceType.WAREHOUSE);


    System.out.println();


    }
}
