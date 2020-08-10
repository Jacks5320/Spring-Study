package com.jk.b_DI_xml.test;

import com.jk.b_DI_xml.demo1.Person;
import com.jk.b_DI_xml.demo1.Student;
import com.jk.b_DI_xml.demo2.Employee;
import com.jk.b_DI_xml.demo3.Collection;
import com.jk.b_DI_xml.demo4.Student2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDemo {

    //测试基本注入
    @Test
    public void testBaseDI() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("com/jk/b_DI_xml/bean.xml");
        //构造注入
        Student stu = context.getBean("student", Student.class);
        System.out.println(stu);
        //setter注入
        Person person = context.getBean("person", Person.class);
        System.out.println(person);
        //p名称空间注入
        Person personP = context.getBean("personP", Person.class);
        System.out.println(personP);
    }

    //测试 null 值和 xml 中的特殊值注入
    @Test
    public void testNull() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("com/jk/b_DI_xml/bean2.xml");
        //注入 null
        Student s1 = context.getBean("student", Student.class);
        System.out.println(s1);
        Person p1 = context.getBean("person", Person.class);
        System.out.println(p1);
        //注入特殊值
        Student s2 = context.getBean("student2", Student.class);
        System.out.println(s2);
        //注入特殊值
        Person p2 = context.getBean("person2", Person.class);
        System.out.println(p2);
    }

    //bean 类型注入
    @Test
    public void testBeanDI() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("com/jk/b_DI_xml/bean3.xml");
        //外部注入
        Employee e1 = context.getBean("e1", Employee.class);
        System.out.println(e1);
        //级联注入
        Employee e2 = context.getBean("e2", Employee.class);
        System.out.println(e2);
        //内部注入
        Employee e3 = context.getBean("e3", Employee.class);
        System.out.println(e3);
    }

    //测试基本类型得到集合注入
    @Test
    public void testCollection() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("com/jk/b_DI_xml/bean4.xml");
        Collection c = context.getBean("c", Collection.class);
        System.out.println(c);
    }

    // 对象类型的集合注入
    @Test
    public void testObjectCollection() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("com/jk/b_DI_xml/bean5.xml");
        Student2 student = context.getBean("student", Student2.class);
        System.out.println(student);
    }

    //测试提取公共集合
    @Test
    public void testCommonCollection() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("com/jk/b_DI_xml/bean6.xml");
        Student2 s1 = context.getBean("s1", Student2.class);
        System.out.println(s1);
        Student2 s2 = context.getBean("s2", Student2.class);
        System.out.println(s2);
    }

}
