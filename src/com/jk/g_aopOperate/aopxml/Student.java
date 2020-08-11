package com.jk.g_aopOperate.aopxml;

import org.springframework.stereotype.Component;

//被增强的类
@Component
public class Student {

    public void run(){
        System.out.println("run 方法执行了");
    }
}
