package com.jk.b_DI_xml.service;

import com.jk.b_DI_xml.dao.UserDao;

public class UserService {

    //创建 UserDao 的属性，生成 setter 方法。
    private UserDao ud;

    public void setUd(UserDao ud) {
        this.ud = ud;
    }

    public void run() {
        System.out.println("service 执行了");
        ud.doIt();
        //原始方式
        // UserDao ud = new UserDaoImpl();
        // ud.doIt();
    }
}
