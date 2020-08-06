package com.jk.f_annotations.service;


import com.jk.f_annotations.dao.UserDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

// value 属性值可以不写，默认会使用首字母小写后的类名
// UserService =>> userService
// @Component(value = "userService")//等价于配置文件中<bean id="userService" class="com.jk.service.UserService">
@Service
public class UserService {

    @Value(value = "张三")
    private String name;

    /*
        根据类型自定装配@Autowired
     */
    // @Autowired
    // private UserDao ud;

    /*
        根据名称指定注入对象 @Qualifier(value = "dao1")
        要与@Autowired 一起使用
     */
    // @Autowired
    // @Qualifier(value = "dao1")
    // private UserDao ud;

    /*
        @Resource   根据类型进行注入
        @Resource(name = "")    根据名称注入
     */
    @Resource(name = "dao1")
    private UserDao ud;
    public void run(){
        System.out.println("service方法执行了...");
        ud.doIt();
        System.out.println("普通属性注入了" + this.name);
    }
}
