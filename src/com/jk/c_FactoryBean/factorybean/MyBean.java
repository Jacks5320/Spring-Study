package com.jk.c_FactoryBean.factorybean;

import org.springframework.beans.factory.FactoryBean;

public class MyBean implements FactoryBean<Student> {

    //  定义返回的 bean 对象
    @Override
    public Student getObject() throws Exception {
        Student student = new Student();
        student.setName("张三");
        return student;
    }

    @Override
    public Class<?> getObjectType() {
        return  null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
