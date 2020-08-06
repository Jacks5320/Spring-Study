package com.jk.b_DI_xml.collection;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Demo1 {
    //数组类型
    private String[] courses;
    // list 集合
    private List<String> list;
    // Set 集合
    private Set<String> sets;
    // Map 集合
    private Map<String, String> map;

    public void setCourses(String[] courses) {
        this.courses = courses;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setSets(Set<String> sets) {
        this.sets = sets;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "Demo1{" +
                "courses=" + Arrays.toString(courses) +
                ", list=" + list +
                ", sets=" + sets +
                ", map=" + map +
                '}';
    }
}
