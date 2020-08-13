import com.jk.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * 基本的 CRUD
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class Demo1 {

    @Autowired
    JdbcTemplate jt;

    //保存
    @Test
    public void testSave() {
        String sql = "insert into tb_account value(?,?,?)";
        jt.update(sql, 1, "aaa", 100.0);
        jt.update(sql, 2, "bbb", 1200.0);
        jt.update(sql, 3, "ccc", 1300.0);
        jt.update(sql, 4, "ccc", 2000.0);
    }

    //修改
    @Test
    public void testUpdate() {
        String sql = "update tb_account set name=?,money=? where id=?";
        jt.update(sql, "a2",1000.0,1);
    }

    //删除
    @Test
    public void testDelete() {
        String sql = "delete from tb_account where id=?";
        jt.update(sql, 1);
    }

    //查询一个
    @Test
    public void testFindOne() {
        String sql = "select * from tb_account where id=?";
        List<Account> accounts = jt.query(sql, new BeanPropertyRowMapper<Account>(Account.class), 1);
        System.out.println(accounts.isEmpty()?"没有集合":accounts.get(0));
    }

    //查询全部
    @Test
    public void testFindAll() {
        String sql = "select * from tb_account where money > ?";

        // List<Account> accounts = jt.query(findAll, new RowMapper<Account>() {
        //     /**
        //      * 封装结果集
        //      * @param resultSet 结果集
        //      * @param i 索引,从0开始
        //      * @return 结果集
        //      * @throws SQLException
        //      */
        //     @Override
        //     public Account mapRow(ResultSet resultSet, int i) throws SQLException {
        //         Account account = new Account();
        //         account.setId(resultSet.getInt("id"));
        //         account.setName(resultSet.getString("name"));
        //         account.setMoney(resultSet.getFloat("money"));
        //         return account;
        //     }
        // }, 1000.0);
        List<Account> accounts = jt.query(sql, new BeanPropertyRowMapper<Account>(Account.class), 1000.0);
        for (Account a : accounts) {
            System.out.println(a);
        }
    }

    //聚合函数查询
    @Test
    public void testFind(){
        String sql = "select count(*) from tb_account where money > ?";
        Long count = jt.queryForObject(sql, Long.class, 1000.0);
        System.out.println(count);

    }

}