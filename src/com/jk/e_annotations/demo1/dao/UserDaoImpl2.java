package com.jk.e_annotations.demo1.dao;

import org.springframework.stereotype.Repository;

@Repository(value = "dao2")
public class UserDaoImpl2 implements UserDao{

    @Override
    public void doIt() {
        System.out.println("dao2 方法调用了...");
    }
}