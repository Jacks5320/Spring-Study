package com.jk.b_DI_xml.demo4;

import java.util.List;
import java.util.Map;

public class Student2 {
    private Map<String, Course> map;
    private List<Course> list;

    public void setMap(Map<String, Course> map) {
        this.map = map;
    }

    public void setList(List<Course> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Student2{" +
                "map=" + map +
                ", list=" + list +
                '}';
    }
}
