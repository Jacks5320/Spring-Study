package com.jk.h_aopOperate.annotation;

import org.springframework.stereotype.Component;

//被增强的类
@Component
public class User {
    public void add(){
        System.out.println("add 方法执行了");
    }
}
