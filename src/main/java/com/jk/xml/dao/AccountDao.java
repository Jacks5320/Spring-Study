package com.jk.xml.dao;

import com.jk.xml.entity.Account;

public interface AccountDao {
    //查找
    Account findById(int id);

    //更新
    void updateMoney(int id, float money);
}
