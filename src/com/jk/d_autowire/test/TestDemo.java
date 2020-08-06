package com.jk.d_autowire.test;


import com.jk.d_autowire.autowire.Emp;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 自动装配
 */
public class TestDemo {

    //测试自动注入
    @Test
    public void testAutowire(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("com/jk/d_autowire/bean.xml");
        Emp emp = context.getBean("emp", Emp.class);
        System.out.println(emp);
    }
}
