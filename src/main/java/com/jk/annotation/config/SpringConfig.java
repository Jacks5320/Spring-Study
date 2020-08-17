package com.jk.annotation.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = {"com.jk.annotation"})
@EnableTransactionManagement//开启事务管理，等价于 <tx:annotation-driven transaction-manager="transactionManager"/>
public class SpringConfig {

    //数据库连接池
    @Bean
    public DruidDataSource getDruidDataSource() {
        DruidDataSource db = new DruidDataSource();
        db.setDriverClassName("com.mysql.cj.jdbc.Driver");
        db.setUrl("jdbc:mysql://localhost:3306/example?serverTimezone=Asia/Shanghai");
        db.setUsername("root");
        db.setPassword("root");
        return db;
    }

    // JdbcTemplate 对象
    @Bean
    public JdbcTemplate getJdbcTemplate(DataSource dataSource) {
        JdbcTemplate jt = new JdbcTemplate();
        // 这个 dataSource 会从 IoC 容器中查找
        jt.setDataSource(dataSource);
        return jt;
    }
    
    //事务管理
    @Bean
    public DataSourceTransactionManager getDataSourceTransactionManager(DataSource dataSource) {
        DataSourceTransactionManager dstm = new DataSourceTransactionManager();
        dstm.setDataSource(dataSource);
        return dstm;
    }
}
