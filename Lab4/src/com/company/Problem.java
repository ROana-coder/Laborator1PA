package com.company;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem {


    private Map<School, List<Student>> schPrefMap = new HashMap<>();
    private Map<Student, List<School>> stdPrefMap = new HashMap<>();
    private int numberOfSchools;


    public Problem(Map<School, List<Student>> schPrefMap, Map<Student, List<School>> stdPrefMap) {
        this.schPrefMap = schPrefMap;
        this.stdPrefMap = stdPrefMap;
        this.numberOfSchools = schPrefMap.size();
    }

    public Map<School, List<Student>> getSchPrefMap() {
        return schPrefMap;
    }

    public void setSchPrefMap(Map<School, List<Student>> schPrefMap) {
        this.schPrefMap = schPrefMap;
    }

    public Map<Student, List<School>> getStdPrefMap() {
        return stdPrefMap;
    }

    public void setStdPrefMap(Map<Student, List<School>> stdPrefMap) {
        this.stdPrefMap = stdPrefMap;
    }

}
