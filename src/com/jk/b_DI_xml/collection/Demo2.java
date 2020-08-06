package com.jk.b_DI_xml.collection;

import java.util.List;
import java.util.Map;

/**
 * 对象类型的集合注入
 */
public class Demo2 {
    private List<Student> students;
    private Map<String, Student> maps;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Map<String, Student> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Student> maps) {
        this.maps = maps;
    }

    @Override
    public String toString() {
        return "Demo2{" +
                "students=" + students +
                ", maps=" + maps +
                '}';
    }
}
