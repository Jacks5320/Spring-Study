package com.jk.annotation.dao;

import com.jk.annotation.entity.Account;

public interface AccountDao {
    //查找
    Account findById(int id);

    //更新
    void updateMoney(int id, float money);
}
