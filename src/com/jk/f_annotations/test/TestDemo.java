package com.jk.f_annotations.test;

import com.jk.f_annotations.config.SpringConfig;
import com.jk.f_annotations.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 基于 注解方式的依赖注入
 */
public class TestDemo {

    //测试注解
    @Test
    public void testService() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("com/jk/f_annotations/bean.xml");
        UserService us = context.getBean("userService", UserService.class);
        System.out.println(us);
        us.run();
    }

    //完全注解开发
    @Test
    public void testService2() {
        // 加载配置类
        ApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfig.class);
        UserService us = context.getBean("userService", UserService.class);
        us.run();
    }
}
