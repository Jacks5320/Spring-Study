package com.jk.e_annotations.demo1.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

// value 属性值可以不写，默认会使用首字母小写后的类名
// UserService =>> userService
// @Component(value = "userService")//等价于配置文件中<bean id="userService" class="com.jk.f_annotations.demo1.service.UserService">
@Service
public class UserService {
    /*
        自动按照类型注入基本使用
     */
    // @Autowired
    // private UserDao ud;
    //
    // public void run() {
    //     ud.doIt();
    // }
    /*
        自动注入，当 UserDao有多个实现类的时候，会出现混乱现象。
        Spring 不知道该注入哪个实现类，程序报错。
        此时有两种解决方案：
            1 将变量名改成对应的 id 名
            2 不改变变量名，使用 @Autowired 与 @Qualifier 一同使用。
                用 @Qualifier 的值来确定注入哪一个对象
     */
    //方案一
    // @Autowired
    // private UserDao dao2;
    // public void run() {
    //     dao2.doIt();
    // }
    //方案二
    // @Autowired
    // @Qualifier("dao2")
    // private UserDao dao;
    // public void run() {
    //     dao.doIt();
    // }
    /*
        除了 Spring 提供的注解，Java 自身也有一个注解 javax.annotation.Resource：@Resource
            根据名称注入
     */
    // @Resource(name = "dao1")
    // private UserDao dao;
    // public void run() {
    //     dao.doIt();
    // }
    /*
        注入普通属性
     */
    @Value("小明")
    private String name;
    @Value("12")
    private int age;

    public void run() {
        System.out.println(this.name + "注入成功了。。");
        System.out.println("年龄：" + this.age);
    }
}
