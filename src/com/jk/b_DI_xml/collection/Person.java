package com.jk.b_DI_xml.collection;

import java.util.List;

public class Person {
    private List<String> names;

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    @Override
    public String toString() {
        return "Person{" +
                "names=" + names +
                '}';
    }
}
