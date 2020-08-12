package com.jk.e_annotations.demo1.dao;

import org.springframework.stereotype.Repository;

@Repository(value = "dao1")
public class UserDaoImpl implements UserDao{

    @Override
    public void doIt() {
        System.out.println("dao 方法调用了...");
    }
}
