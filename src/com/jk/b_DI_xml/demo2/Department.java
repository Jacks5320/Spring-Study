package com.jk.b_DI_xml.demo2;

/**
 * 演示 注入 Bean 类型
 */
public class Department {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                '}';
    }
}
