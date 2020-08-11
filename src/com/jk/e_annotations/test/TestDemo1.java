package com.jk.e_annotations.test;

import com.jk.e_annotations.demo1.dao.UserDao;
import com.jk.e_annotations.demo1.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDemo1 {

    //测试创建对象
    @Test
    public void testObject(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("com/jk/e_annotations/bean.xml");
        UserDao dao1 = context.getBean("dao1", UserDao.class);
        dao1.doIt();
        System.out.println(dao1);
    }

    //测试自动注入
    @Test
    public void testService(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("com/jk/e_annotations/bean.xml");
        UserService us = context.getBean("userService", UserService.class);
        System.out.println(us);
        us.run();
    }
}
