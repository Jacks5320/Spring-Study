package com.jk.c_FactoryBean.test;

import com.jk.c_FactoryBean.factorybean.Person;
import com.jk.c_FactoryBean.factorybean.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 工厂 bean
 * 作用域
 * 生命周期 - 后置处理器
 */
public class TestDemo {
    //测试工厂 Bean : 返回类型与配置类型不一样
    @Test
    public void testFactoryBean() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("com/jk/c_FactoryBean/bean.xml");
        Student student = context.getBean("myBean", Student.class);
        System.out.println(student);
    }

    //单实例和多实例验证
    @Test
    public void testFactorySingle() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("com/jk/c_FactoryBean/bean2.xml");
        Student student1 = context.getBean("student", Student.class);
        Student student2 = context.getBean("student", Student.class);
        System.out.println(student1);
        System.out.println(student2);
    }

    //Bean 生命周期验证
    @Test
    public void testBeanLife() {
        // ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("com/jk/c_FactoryBean/bean3.xml");
        Person person = context.getBean("person", Person.class);
        System.out.println("第四步：获取到 Bean 对象了...");
        System.out.println(person);
        //手动调用 Bean 实例销毁方法
        context.close();//close方法是ClassPathXmlApplicationContext中的
    }
}
