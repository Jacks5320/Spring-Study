package com.jk.c_FactoryBean.factorybean;

public class Person {
    private String name;

    public Person() {
        System.out.println("第一步：无参构造执行了...");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("第二部：setter 方法调用了...");
    }

    //创建执行初始化的方法
    public void initMethod(){
        System.out.println("第三步：初始化的方法执行了...");
    }

    //销毁方法
    public void destroyMethod(){
        System.out.println("第五步：执行销毁方法执行了...");
    }
}
