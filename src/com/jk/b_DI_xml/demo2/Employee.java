package com.jk.b_DI_xml.demo2;

/**
 * 演示注入 bean 类型
 */
public class Employee {
    private String name;
    //员工属于某一个部门,使用对象形式表示
    private Department dept;

    public void setName(String name) {
        this.name = name;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }

    public Department getDept() {
        return dept;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", dept=" + dept +
                '}';
    }
}
