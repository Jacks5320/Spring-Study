package com.jk.f_aopProxy.demo2;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 使用 CGLIB 提供的 Enhancer 实现动态代理
 */
public class Client {
    public static void main(String[] args) {
        final Producer producer = new Producer();
    /*
        动态代理：
            特点：字节码随用随创建，随用随加载。
            作用：不修改源码的基础上对方法增强
            分类：
                基于接口的动态代理
                基于子类的动态代理

            基于子类的动态代理：
                涉及的类：Enhancer
                提供者：第三方 CGLIB 库
            如何创建代理对象：
                被代理类不能是最终类

            创建代理对象的要求：
                被代理类最少实现一个接口，如果没有则不能使用

            create 方法的参数：
                - type：
                    - 指定被代理对象的字节码
                - Callback：
                    - 用于提供增强的代码
                    - 让我们写如何代理，一般都是写一个该接口的实现类。
                    - 通常情况下都是匿名内部类，但不是必须的。
                    - 我们一般写的都是该接口的子接口实现类：MethodInterceptor
     */
        Producer cglibProducer = (Producer) Enhancer.create(producer.getClass(), new MethodInterceptor() {
            /**
             * 执行被代理对象的任何方法都会经过该方法
             * @param o     被代理实例
             * @param method    方法
             * @param objects   参数
             * 以上三个参数和基于接口的动态代理中invoke方法的参数是一样的。
             * @param methodProxy 当前执行方法的代理对象
             * @return  与被代理对象 方法 的返回值一致
             * @throws Throwable
             */
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                Object rs = null;
                Float money = (Float) objects[0];
                if ("saleProduct".equals(method.getName())) {
                    rs = method.invoke(producer, money * 0.8f);
                }
                return rs;
            }
        });
        cglibProducer.saleProduct(1000);

    }
}
