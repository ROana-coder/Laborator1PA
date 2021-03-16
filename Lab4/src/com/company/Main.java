package com.company;

import java.io.StringWriter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static <Faker> void main(String[] args) {
        var students = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Student("S" + i))
                .toArray(Student[]::new);

        LinkedList<Student> studentList = new LinkedList<>(Arrays.asList(students));

        //System.out.println(Arrays.toString(students));
        Student s0 = new Student("S0");
        //studentList.add(s0);
        //System.out.println(studentList);
        List<Student> newSortedList = new ArrayList<>(studentList);
        newSortedList.sort(Comparator.comparing(Student::getName));
        //System.out.println(newSortedList);

        var schools = IntStream.rangeClosed(0, 2)
                .mapToObj(i -> new School("H" + i))
                .sorted()
                .toArray(School[]::new);

        TreeSet<School> schoolSet = new TreeSet<School>();
        School h0 = new School("H0");
        h0.setCapacity(1);
        schoolSet.add(h0);
        School h1 = new School("H1");
        schoolSet.add(h1);
        h1.setCapacity(2);
        School h2 = new School("H2");
        schoolSet.add(h2);
        h2.setCapacity(2);
        /*for(School number : schoolSet){
            System.out.println(number.getName());
        }*/
        ArrayList<School> schoolList = new ArrayList<School>(schoolSet);

        Map<Student, List<School>> stdPrefMap = new HashMap<>();
        List<School> prefList0 = new ArrayList<>(schoolList);
        List<School> prefList2 = new ArrayList<>();
        List<School> prefList3 = new ArrayList<>();
        prefList2 = schoolList.stream().filter(s -> s.getName() != "H2").collect(Collectors.toList());
        prefList3 = schoolList.stream().filter(s -> s.getName() != "H1").collect(Collectors.toList());
        //System.out.println(prefList0);
        /*boolean h0 = prefList.add(schoolList.get(0));
        boolean h1 = prefList.add(schoolList.get(1));
        boolean h2 = prefList.add(schoolList.get(2));*/

        stdPrefMap.put(students[0], prefList0);
        stdPrefMap.put(students[1], prefList0);
        stdPrefMap.put(students[2], prefList2);
        stdPrefMap.put(students[3], prefList3);

        Map<School, List<Student>> schPrefMap = new HashMap<>();
        List<Student> prefSList1 = new ArrayList<>();
        prefSList1.add(studentList.get(0));
        prefSList1.add(studentList.get(1));
        prefSList1.add(studentList.get(2));

        schPrefMap.put(schools[0], Arrays.asList(studentList.get(3), studentList.get(0), studentList.get(1), studentList.get(2)));
        schPrefMap.put(schools[1], Arrays.asList(studentList.get(0), studentList.get(2), studentList.get(1)));
        schPrefMap.put(schools[2], Arrays.asList(studentList.get(0), studentList.get(1), studentList.get(3)));

        for (Map.Entry<Student, List<School>> entry : stdPrefMap.entrySet()) {
            Student key = entry.getKey();
            List<School> s = entry.getValue();
            System.out.println(key.getName() + ':' + s);

        }
        for (Map.Entry<School, List<Student>> entry : schPrefMap.entrySet()) {
            School key = entry.getKey();
            List<Student> s = entry.getValue();
            System.out.println(key.getName() + ':' + s);

        }

        Problem problem = new Problem(schPrefMap, stdPrefMap);
        Solution solution = new Solution(problem);
        solution.solution();

        List<School> target = Arrays.asList(schools[2]);
        studentList.stream()
                .filter(std -> stdPrefMap.get(std).containsAll(target))
                .forEach(System.out::println);

        Student firststd = students[0];

        schoolSet.stream().filter(school -> schPrefMap.get(school).get(0).equals(firststd)).forEach(System.out::println);

       

    }

}
