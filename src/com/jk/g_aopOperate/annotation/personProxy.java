package com.jk.g_aopOperate.annotation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class personProxy {
    @Before(value = "execution(* com.jk.g_aopOperate.annotation.User.add(..))")
    public void before() {
        System.out.println("personProxy Before...");
    }
}
