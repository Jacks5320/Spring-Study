package com.jk.dao;

import com.jk.domain.Account;

import java.util.List;

public interface AccountDao {
    //根据ID查
    Account findById(Integer id);

    //根据名称查
    Account findByName(String name);

    //更新
    void updateAccount(Account account);

    //批量添加
    void batchAdd(List<Object[]> args);

    //批量修改
    void batchUpdate(List<Object[]> args);

    //批量删除
    void batchDelete(List<Object[]> args);
}
