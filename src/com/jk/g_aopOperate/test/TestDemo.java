package com.jk.g_aopOperate.test;

import com.jk.g_aopOperate.annotation.User;
import com.jk.g_aopOperate.aopxml.Student;
import com.jk.g_aopOperate.config.AopConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDemo {

    //测试注解实现AOP
    @Test
    public void testAnnotation(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("com/jk/g_aopOperate/bean.xml");
        User user = context.getBean("user", User.class);
        user.add();
    }

    // 测试 xml 实现 aop
    @Test
    public void testAopXml(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("com/jk/g_aopOperate/bean2.xml");
        Student student = context.getBean("student", Student.class);
        student.run();
    }

    //完全注解开发测试
    @Test
    public void testNoXml(){
        ApplicationContext context =
                new AnnotationConfigApplicationContext(AopConfig.class);
        Student student = context.getBean("student", Student.class);
        student.run();
    }
}
