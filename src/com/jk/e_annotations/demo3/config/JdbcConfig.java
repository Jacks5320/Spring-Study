package com.jk.e_annotations.demo3.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Bean 注解
 * 作用：把当前对象的返回值存入 Spring IoC容器
 * 属性：name，用于指定 Bean 的 id，默认值为当前方法的名称。
 * 细节：当使用注解配置方法时，如果方法有参数，Spring框架回去容器中查找有没有可用的 Bean对象。
 * 查找方式与 @Autowired 一样。
 */
@Configuration
@PropertySource("classpath:com/jk/e_annotations/demo3/config/jdbc.properties")
public class JdbcConfig {

    //jdbc连接信息
    @Value("${jdbc.driver}")
    String driver;
    @Value("${jdbc.url}")
    String url;
    @Value("${jdbc.username}")
    String username;
    @Value("${jdbc.password}")
    String password;

    /**
     * 创建数据源对象
     */
    // @Bean("dataSource")
    // public DruidDataSource createDataSource(){
    //     DruidDataSource ds =  new DruidDataSource();
    //     ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
    //     ds.setUrl("jdbc:mysql://localhost:3306/example?serverTimezone=Asia/Shanghai");
    //     ds.setUsername("root");
    //     ds.setPassword("root");
    //     return ds;
    // }
    @Bean("dataSource")
    public DruidDataSource createDataSource() {
        DruidDataSource ds = new DruidDataSource();
        ds.setDriverClassName(driver);
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);
        return ds;
    }

    @Bean("dataSource2")
    public DruidDataSource createDataSource2() {
        DruidDataSource ds = new DruidDataSource();
        ds.setDriverClassName(driver);
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword("");
        return ds;
    }

    /**
     * 创建 JdbcTemplate 对象
     */
    @Bean("jt")
    @Scope("prototype")
    public JdbcTemplate createJt(@Qualifier("dataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
