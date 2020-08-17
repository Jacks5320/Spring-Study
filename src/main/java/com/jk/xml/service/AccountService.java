package com.jk.xml.service;

import com.jk.xml.dao.AccountDao;
import com.jk.xml.entity.Account;

public class AccountService {
    private AccountDao ad;

    public void setAd(AccountDao ad) {
        this.ad = ad;
    }
    
    //转账
    public void transferMoney(int sendId, int receiveId, float money) {
        Account a1 = ad.findById(sendId);
        Account a2 = ad.findById(receiveId);
        if (a1 == null || a2 == null) {
            throw new RuntimeException("账户出错");
        }
        ad.updateMoney(a1.getId(), a1.getMoney() - money);
//        int a = 1 / 0;//手动造异常，引入事务场景。
        ad.updateMoney(a2.getId(), a2.getMoney() + money);
    }
}
