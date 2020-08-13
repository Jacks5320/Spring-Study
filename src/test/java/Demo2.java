import com.jk.dao.AccountDao;
import com.jk.domain.Account;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试持久层
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class Demo2 {

    @Autowired
    AccountDao ad;

    //查询一个
    @Test
    public void testFindOne() {
        Account a = ad.findById(1);
        System.out.println(a);
    }

    //更新
    @Test
    public void testUpdate() {
        Account a = ad.findById(1);
        System.out.println(a);
        a.setMoney(900f);
        ad.updateAccount(a);
    }

    //批量添加
    @Test
    public void testBatchAdd() {
        List<Object[]> args = new ArrayList<>();
        Object[] o1 = {3, "ccc", 5000f};
        Object[] o2 = {4, "ddd", 6000f};
        Object[] o3 = {5, "eee", 7000f};
        args.add(o1);
        args.add(o2);
        args.add(o3);
        ad.batchAdd(args);
    }

    //批量修改
    @Test
    public void testBatchUpdate() {
        List<Object[]> args = new ArrayList<>();
        Object[] o1 = {"sss", 8000f, 3};
        Object[] o2 = {"QQQ", 9000f, 4};
        Object[] o3 = {"MMM", 10000f, 5};
        args.add(o1);
        args.add(o2);
        args.add(o3);
        ad.batchUpdate(args);
    }

    //批量删除
    @Test
    public void testBatchDelete() {
        List<Object[]> args = new ArrayList<>();
        Object[] o1 = {3};
        Object[] o2 = {4};
        Object[] o3 = {5};
        args.add(o1);
        args.add(o2);
        args.add(o3);
        ad.batchDelete(args);
    }

}