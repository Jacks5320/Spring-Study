package com.jk.dao.impl;

import com.jk.dao.AccountDao;
import com.jk.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.Arrays;
import java.util.List;

/**
 * 基于 xml 配置，继承 JdbcDaoSupport，使用getJdbcTemplate() 方法获取模板。
 */
public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {

    // 继承 JdbcDaoSupport 后不再需要自己注入
    // private JdbcTemplate jt;
    //
    // public void setJt(JdbcTemplate jt) {
    //     this.jt = jt;
    // }

    @Override
    public Account findById(Integer id) {
        String sql = "select * from tb_account where id=?";
        List<Account> accounts = super.getJdbcTemplate().query(sql, new BeanPropertyRowMapper<Account>(Account.class), id);
        return accounts.isEmpty() ? null : accounts.get(0);
    }

    @Override
    public Account findByName(String name) {
        String sql = "select * from tb_account where name=?";
        List<Account> accounts = super.getJdbcTemplate().query(sql, new BeanPropertyRowMapper<Account>(Account.class), name);
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
        super.getJdbcTemplate().update(sql, account.getName(), account.getMoney(), account.getId());
    }

    @Override
    public void batchAdd(List<Object[]> args) {
        String sql = "insert into tb_account value(?,?,?)";
        int[] ints = super.getJdbcTemplate().batchUpdate(sql, args);
        System.out.println(Arrays.toString(ints));
    }

    @Override
    public void batchUpdate(List<Object[]> args) {
        String sql = "update tb_account set name=?,money=? where id=?";
        int[] ints = super.getJdbcTemplate().batchUpdate(sql, args);
        System.out.println(Arrays.toString(ints));
    }

    @Override
    public void batchDelete(List<Object[]> args) {
        String sql = "delete from tb_account where id=?";
        int[] ints = super.getJdbcTemplate().batchUpdate(sql, args);
        System.out.println(Arrays.toString(ints));
    }
}