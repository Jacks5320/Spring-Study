package com.jk.f_aopProxy.demo1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * 使用 JDK 提供的 Proxy 实现动态代理
 */
public class JDKProxy {

    /*
        动态代理：
            特点：字节码随用随创建，随用随加载。
            作用：不修改源码的基础上对方法增强
            分类：
                基于接口的动态代理
                基于子类的动态代理

            基于接口的动态代理：
                涉及的类：Proxy
                提供者：JDK官方
            如何创建代理对象：
                使用 Proxy 类中的 newProxyInstance 方法

            创建代理对象的要求：
                被代理类最少实现一个接口，如果没有则不能使用

            newProxyInstance 方法的参数：
                - ClassLoader：
                    - 用于加载代理对象字节码
                    - 写的是被代理对象的类加载器
                    - 和被代理对象使用相同的类加载器。
                    - 是固定写法
                - Class<>[]:
                    - 用于让代理对象和被代理对象有相同的方法。
                    - 固定写法
                - InvocationHandler：
                    - 用于提供增强的代码
                    - 让我们写如何代理，一般都是写一个该接口的实现类。
                    - 通常情况下都是匿名内部类，但不是必须的。
                    - 此接口的实现类都是谁用谁写。
     */
    public static void main(String[] args) {
        final UserDaoImpl udi = new UserDaoImpl();

        //匿名内部类的方式，在内部实现 InvocationHandler 接口
        UserDao ud = (UserDao)Proxy.newProxyInstance(JDKProxy.class.getClassLoader(),
                UserDaoImpl.class.getInterfaces(), new InvocationHandler() {
                    /**
                     * 作用：执行被代理对象的任何接口方法都会经过该方法，具有拦截过滤功能
                     * @param proxy 代理对象的引用，在其上调用方法的代理实例。
                     * @param method 当前执行的 方法
                     * @param args  当前执行 方法 所需的参数,可以通过索引来操作
                     * @return  和被代理对象 方法 有相同的返回值
                     * @throws Throwable
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                        //提供增强代码
                        if ("add".equals(method.getName())) {
                            Object obj = (Integer) method.invoke(udi, args) * 10;
                            return obj;
                        }
                        if ("update".equals(method.getName())) {
                            Object obj = method.invoke(udi, "欢迎 " + args[0]);
                            return obj;
                        }
                        //不影响未增强的方法
                        return method.invoke(udi, args);
                    }
                });
        System.out.println(ud.add(1,2));
        System.out.println(ud.update("Roan"));
        ud.run("Jacks");
        //外部实现 InvocationHandler 接口
        // UserDaoImpl udi = new UserDaoImpl();
        // UserDao ud = (UserDao) Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), interfaces, new UserDaoProxy(udi));
        // int rs = ud.add(1, 2);
        // System.out.println("结果：" + rs);
    }
}

//创建代理对象代码
class UserDaoProxy implements InvocationHandler {
    // 把被代理的对象传进来，有参构造
    private final Object obj;

    public UserDaoProxy(Object obj) {
        this.obj = obj;
    }

    //增强的逻辑
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //方法之前
        System.out.println("在方法之前执行。。。方法名：" + method.getName() + "--传递的参数：" + Arrays.toString(args));
        //被增强的方法执行
        Object res = method.invoke(obj, args);
        //方法之后
        System.out.println("在方法之后执行。。。" + obj);
        return res;
    }
}
