package com.jk.h_aopOperate.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 增强类
 */
@Component
@Aspect     //生成代理对象
@Order(3)
public class UserProxy {

    //相同切入点抽取
    @Pointcut(value = "execution(* com.jk.h_aopOperate.annotation.User.add(..))")
    public void pointDemo(){}

    //前置通知

    // @Before(value = "execution(* com.jk.aop.annotation.User.add(..))")
    @Before("pointDemo()")      //抽取公共切入点
    public void before(){
        System.out.println("before...");
    }
    //最终通知：方法执行之后，无论有没有异常都会通知
    @After(value = "execution(* com.jk.h_aopOperate.annotation.User.add(..))")
    public void after() {
        System.out.println("after...");
    }

    //后置通知（返回通知）：方法返回值 之后执行，有异常则不会通知
    @AfterReturning(value = "execution(* com.jk.h_aopOperate.annotation.User.add(..))")
    public void afterReturning(){
        System.out.println("afterReturning...");
    }

    //异常通知：当方法有异常时执行
    @AfterThrowing(value = "execution(* com.jk.h_aopOperate.annotation.User.add(..))")
    public void afterThrowing(){
        System.out.println("afterThrowing...");
    }

    //环绕通知：在方法执行前后都会通知，如果有异常，则环绕之后不会通知，环绕之前依旧通知。
    @Around(value = "execution(* com.jk.h_aopOperate.annotation.User.add(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕之前。。。");
        //被增强的方法执行
        proceedingJoinPoint.proceed();
        System.out.println("环绕之后...");
    }
}
