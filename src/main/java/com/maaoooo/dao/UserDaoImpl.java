package com.maaoooo.dao;

import com.maaoooo.bean.User;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author lzr
 * @date 2020 05 10 22:03
 * @description
 */
public class UserDaoImpl implements UserDao{
    private static ComboPooledDataSource pooledDataSource;
    static {
        //配置c3p0 连接数据库
        try {
            pooledDataSource=new ComboPooledDataSource();
            pooledDataSource.setDriverClass("com.mysql.jdbc.Driver");
            pooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/webtest");
            pooledDataSource.setUser("root");
            pooledDataSource.setPassword("root");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public User selectUserById() {
        JdbcTemplate jt = new JdbcTemplate(pooledDataSource);
        return null;
    }
}
