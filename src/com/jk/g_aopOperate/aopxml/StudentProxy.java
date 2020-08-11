package com.jk.g_aopOperate.aopxml;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 增强类
 */
@Component
@Aspect     //生成代理对象
public class StudentProxy {

    @Before(value = "execution(* com.jk.g_aopOperate.aopxml.Student.run(..))")
    public void before() {
        System.out.println("before...");
    }

}
