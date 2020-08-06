package com.jk.f_annotations.dao;

import org.springframework.stereotype.Repository;

@Repository(value = "dao1")
public class UserDaoImpl implements UserDao{

    @Override
    public void doIt() {
        System.out.println("dao 方法调用了...");
    }
}
