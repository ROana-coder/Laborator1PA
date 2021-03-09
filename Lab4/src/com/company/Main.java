package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        Student s0 = new Student("S0");
        Student s1 = new Student("S1");
        Student s2 = new Student("S2");
        Student s3 = new Student("S3");
        var students = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Student("S" + i) )
                .toArray(Student[]::new);
        List<Student> studentList = new ArrayList<>();
        // add elements, one by one
        studentList.add(s0);
        studentList.add(s1);

        for (Student s : students) {
            studentList.add(s);
        }

        studentList.addAll( Arrays.asList(students) );
    }
}
