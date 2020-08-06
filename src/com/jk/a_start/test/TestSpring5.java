package com.jk.a_start.test;

import com.jk.a_start.spring5.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
Spring 入门案例
    bean 文件中包括了基本的注入方式
 */
public class TestSpring5 {

    @Test
    public void testUser() {
        //1 加载 spring 配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("com/jk/a_start/bean.xml");
        //2 获取配置创建的对象
        User user = context.getBean("user", User.class);
        System.out.println(user);
    }
}
