package com.jk.b_DI_xml.test;

import com.jk.b_DI_xml.bean.Emp;
import com.jk.b_DI_xml.collection.Demo1;
import com.jk.b_DI_xml.collection.Demo2;
import com.jk.b_DI_xml.collection.Person;
import com.jk.b_DI_xml.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// 基于 xml 方式的 依赖注入
public class TestDemo {
    //注入外部bean
    @Test
    public void testUser() {
        // 加载配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("com/jk/b_DI_xml/bean.xml");
        // 获取对象
        UserService us = context.getBean("userService", UserService.class);
        //调用方法
        us.run();
    }

    // 注入内部bean
    @Test
    public void testEmp() {
        // 加载配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("com/jk/b_DI_xml/bean2.xml");
        // 获取对象
        Emp emp = context.getBean("emp", Emp.class);
        //调用方法
        System.out.println(emp);
    }

    //级联注入
    @Test
    public void testEmp2() {
        // 加载配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("com/jk/b_DI_xml/bean3.xml");
        // 获取对象
        Emp emp = context.getBean("emp", Emp.class);
        //调用方法
        System.out.println(emp);
    }

    //集合注入-普通类型
    @Test
    public void testCollection1() {
        // 加载配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("com/jk/b_DI_xml/bean4.xml");
        // 获取对象
        Demo1 demo1 = context.getBean("demo1", Demo1.class);
        System.out.println(demo1);
    }

    //集合注入-对象类型
    @Test
    public void testCollection2() {
        // 加载配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("com/jk/b_DI_xml/bean5.xml");
        // 获取对象
        Demo2 demo2 = context.getBean("demo2", Demo2.class);
        System.out.println(demo2);
    }

    // 提取 list 部分
    @Test
    public void testCollection3() {
        // 加载配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("com/jk/b_DI_xml/bean6.xml");
        // 获取对象
        Person person = context.getBean("persons", Person.class);
        System.out.println(person);
    }

}
