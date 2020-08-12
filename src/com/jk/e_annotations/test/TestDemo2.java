package com.jk.e_annotations.test;

import com.jk.e_annotations.demo2.BeanLife;
import com.jk.e_annotations.demo2.ScopeDemo;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDemo2 {

    //测试作用域
    @Test
    public void testScope() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("com/jk/e_annotations/bean.xml");
        ScopeDemo s1 = context.getBean("scopeDemo", ScopeDemo.class);
        ScopeDemo s2 = context.getBean("scopeDemo", ScopeDemo.class);
        System.out.println(s1 == s2);
    }
    //测试生命周期
    @Test
    public void testLife() {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("com/jk/e_annotations/bean.xml");
        BeanLife b = context.getBean("beanLife", BeanLife.class);
        System.out.println(b);
        context.close();
    }
}
