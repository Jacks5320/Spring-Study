package com.jk.f_aopProxy.demo1;

public class UserDaoImpl implements UserDao{
    @Override
    public int add(int a, int b) {
        System.out.println("add方法执行了。。。");
        return a + b;
    }

    @Override
    public String update(String name) {
        System.out.println("update方法执行了。。。");
        return name;
    }

    @Override
    public void run(String name) {
        System.out.println("run 方法执行了。。。=>>" + name + "跑起来了。");
    }
}
