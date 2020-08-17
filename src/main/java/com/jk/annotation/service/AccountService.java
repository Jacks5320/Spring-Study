package com.jk.annotation.service;

import com.jk.annotation.dao.AccountDao;
import com.jk.annotation.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 注解 @Transactional
 * - 标注在类上，表示所有的方法都加上事务，
 * - 标注在方法上，只给标注了的方法添加事务。
 * 参数：
 * - transactionManager
 * - propagation：事务传播行为
 * 多事务方法之间进行调用，这个过程中事务如何管理。
 * 7种传播行为：
 * PROPAGATION_REQUIRED
 * Spring默认的传播机制，能满足绝大部分业务需求，如果外层有事务，则当前事务加入到外层事务，一块提交，一块回滚。如果外层没有事务，新建一个事务执行
 * PROPAGATION_REQUES_NEW
 * 该事务传播机制是每次都会新开启一个事务，同时把外层事务挂起，当当前事务执行完毕，恢复上层事务的执行。如果外层没有事务，执行当前新开启的事务即可
 * PROPAGATION_SUPPORT
 * 如果外层有事务，则加入外层事务，如果外层没有事务，则直接使用非事务方式执行。完全依赖外层的事务
 * PROPAGATION_NOT_SUPPORT
 * 该传播机制不支持事务，如果外层存在事务则挂起，执行完当前代码，则恢复外层事务，无论是否异常都不会回滚当前的代码
 * PROPAGATION_NEVER
 * 该传播机制不支持外层事务，即如果外层有事务就抛出异常
 * PROPAGATION_MANDATORY
 * 与NEVER相反，如果外层没有事务，则抛出异常
 * PROPAGATION_NESTED
 * 该传播机制的特点是可以保存状态保存点，当前事务回滚到某一个点，从而避免所有的嵌套事务都回滚，即各自回滚各自的，如果子事务没有把异常吃掉，基本还是会引起全部回滚的。
 * - isolation：事务隔离级别
 * - timeout：超时时间，默认值为 -1 永不超时
 * - readOnly ：只读
 * - rollbackFor:异常回滚
 * - noRollbackFor：异常不会回滚
 */
//等价于
// <tx:method name="*Money"
//            propagation="REQUIRED"
//            isolation="DEFAULT"
//            read-only="false"
//            timeout="-1"
//            rollback-for="java.lang.ArithmeticException"/>
@Transactional(propagation = Propagation.REQUIRED,
        isolation = Isolation.DEFAULT,
        timeout = -1,
        readOnly = false,
        noRollbackFor = ArithmeticException.class)
@Service
public class AccountService {
    @Autowired
    private AccountDao ad;
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
