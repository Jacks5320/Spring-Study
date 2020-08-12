package com.jk.e_annotations.test;

import com.jk.e_annotations.demo3.config.SpringConfig;
import com.jk.e_annotations.demo3.dao.UserDao;
import com.jk.e_annotations.demo3.entity.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class TestDemo3 {

    //测试完全注解开发
    @Test
    public void testDemo(){
        ApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfig.class);
        UserDao userDao = context.getBean("userDao", UserDao.class);
        User u = userDao.findOne(1);
        System.out.println(u);
    }

    //测试 Scope 注解在 配置类中的作用
    @Test
    public void testSingleton(){
        ApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfig.class);
        JdbcTemplate jt1 = context.getBean("jt", JdbcTemplate.class);
        JdbcTemplate jt2 = context.getBean("jt", JdbcTemplate.class);
        System.out.println(jt1 == jt2);
    }
}
