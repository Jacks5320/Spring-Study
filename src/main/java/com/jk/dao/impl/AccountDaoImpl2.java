package com.jk.dao.impl;

import com.jk.dao.AccountDao;
import com.jk.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 这是 基于 注解版本的持久层写法，使用 @Autowired 注解自动注入 模板
 */
@Repository
public class AccountDaoImpl2 implements AccountDao {

    @Autowired
    private JdbcTemplate jt;

    @Override
    public Account findById(Integer id) {
        String sql = "select * from tb_account where id=?";
        List<Account> accounts = jt.query(sql, new BeanPropertyRowMapper<Account>(Account.class), id);
        return accounts.isEmpty() ? null : accounts.get(0);
    }

    @Override
    public Account findByName(String name) {
        String sql = "select * from tb_account where name=?";
        List<Account> accounts = jt.query(sql, new BeanPropertyRowMapper<Account>(Account.class), name);
        if (accounts.isEmpty()) {
            return null;
        }
        if (accounts.size() > 1) {
            throw new RuntimeException("结果集不唯一");
        }
        return accounts.get(0);
    }

    @Override
    public void updateAccount(Account account) {
        String sql = "update tb_account set name=?,money=? where id=?";
        jt.update(sql, account.getName(), account.getMoney(), account.getId());
    }

    @Override
    public void batchAdd(List<Object[]> args) {

    }

    @Override
    public void batchUpdate(List<Object[]> args) {

    }

    @Override
    public void batchDelete(List<Object[]> args) {

    }
}