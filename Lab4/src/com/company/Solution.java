package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Solution {
    private Problem problem;


    public Solution(Problem problem) {
        this.problem = problem;
    }

    public void solution ()
    {
        for (Map.Entry<Student, List<School>> entry : problem.getStdPrefMap().entrySet()) {
            int positions[] = new int[100];
            int n = 0;
            Student key = entry.getKey();
            School toGo = new School("NotASchool");
            List<School> s = entry.getValue();

            for (Map.Entry<School, List<Student>> entry1 : problem.getSchPrefMap().entrySet()) {
                int poz = -1;
                School key1 = entry1.getKey();
                List<Student> s1 = entry1.getValue();
                for(Student find : s1)
                {
                    poz++;
                    if(find == key)  break;
                }
                //System.out.println(key1.getName() + ':' + s1);
                positions[n] = poz;
                n++;
            }
            n = problem.getSchPrefMap().size();
            //System.out.println(key.getName() + ':' + Arrays.toString(positions));
            int minim = n+1;
            int pozmin = 0;
            for(int i = 0; i < (n-1); i++)
                if(positions[i] < minim && (s.get(i).getCapacity() - 1 >= 0))
                {
                    minim = positions[i];
                    pozmin = i;
                    //break;
                }
            ///System.out.println(s.get(pozmin).getCapacity());
            //s.get(pozmin).decrementCapacity();
            //System.out.println(s.get(pozmin).getCapacity());
            //System.out.println("Hello");
            System.out.println(key.getName() + ':' + s.get(pozmin).getName());
        }
    }

}
