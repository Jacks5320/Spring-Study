package com.jk.b_DI_xml.demo1;

/**
 * 演示 setter 注入
 */
public class Person {
    private String name;
    private String gender;

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
