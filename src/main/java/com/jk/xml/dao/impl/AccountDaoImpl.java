package com.jk.xml.dao.impl;

import com.jk.xml.dao.AccountDao;
import com.jk.xml.entity.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class AccountDaoImpl implements AccountDao {

    private JdbcTemplate jt;

    public void setJt(JdbcTemplate jt) {
        this.jt = jt;
    }

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
