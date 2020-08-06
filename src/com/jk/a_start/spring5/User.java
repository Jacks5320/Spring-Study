package com.jk.a_start.spring5;

/**
* @description: Spring 基本入门案例，包含了基于 xml 方式的基本注入：setter注入，构造注入，p命名空间注入等。
* @author: Jacks丶
* @date:
* @version: 1.0
*/

public class User {
    private String name;
    private int age;

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
