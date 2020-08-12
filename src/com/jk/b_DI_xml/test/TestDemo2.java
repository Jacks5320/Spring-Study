package com.jk.b_DI_xml.test;

import com.jk.b_DI_xml.demo5.ScopeDemo;
import com.jk.b_DI_xml.demo6.BeanLife;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 作用范围与生命周期验证
 */
public class TestDemo2 {

    //测试单例对象
    @Test
    public void testSingleton() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("com/jk/b_DI_xml/bean8.xml");
        ScopeDemo s1 = context.getBean("s1", ScopeDemo.class);
        ScopeDemo s2 = context.getBean("s1", ScopeDemo.class);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s1 == s2);
    }

    // 测试多例对象
    @Test
    public void testPrototype() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("com/jk/b_DI_xml/bean8.xml");
        ScopeDemo s1 = context.getBean("s2", ScopeDemo.class);
        ScopeDemo s2 = context.getBean("s2", ScopeDemo.class);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s1 == s2);
    }

    //测试生命周期
    @Test
    public void testLife(){
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("com/jk/b_DI_xml/bean9.xml");
        // 单例
        BeanLife l1 = context.getBean("l1", BeanLife.class);
        System.out.println(l1);
        // 多例
        // BeanLife l2 = context.getBean("l2", BeanLife.class);
        // System.out.println(l2);
        //手动关闭容器
        context.close();
    }
}
