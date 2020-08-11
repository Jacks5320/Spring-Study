package com.jk.e_annotations.demo3.dao.impl;

import com.jk.e_annotations.demo3.dao.UserDao;
import com.jk.e_annotations.demo3.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
    @Autowired
    private JdbcTemplate jt;

    @Override
    public User findOne(int id) {
        String sql = "select * from tb_user where id=?";
        return jt.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),id);
    }
}
