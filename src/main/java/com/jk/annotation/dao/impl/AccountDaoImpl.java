package com.jk.annotation.dao.impl;

import com.jk.annotation.dao.AccountDao;
import com.jk.annotation.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class AccountDaoImpl implements AccountDao {

    @Autowired
    JdbcTemplate jt;

    @Override
    public Account findById(int id) {
        String sql = "select * from tb_account where id=?";
        List<Account> lists = jt.query(sql, new BeanPropertyRowMapper<Account>(Account.class), id);
        return lists.isEmpty() ? null : lists.get(0);
    }

    @Override
    public void updateMoney(int id, float money) {
        String sql = "update tb_account set money=? where id=?";
        jt.update(sql, money, id);
    }
}
