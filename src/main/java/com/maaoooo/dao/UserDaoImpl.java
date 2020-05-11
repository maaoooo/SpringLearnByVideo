package com.maaoooo.dao;

import com.maaoooo.bean.User;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author lzr
 * @date 2020 05 10 22:03
 * @description
 */
public class UserDaoImpl implements UserDao{
//    private static ComboPooledDataSource pooledDataSource;
    JdbcTemplate jt;

//    static {
//        //配置c3p0 连接数据库
//        try {
//            pooledDataSource=new ComboPooledDataSource();
//            pooledDataSource.setDriverClass("com.mysql.jdbc.Driver");
//            pooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/webtest");
//            pooledDataSource.setUser("root");
//            pooledDataSource.setPassword("root");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }


    //保存用户
    @Override
    public void saveUser(User u) {
        String sql="insert into user value(null,?,?)";
        jt.update(sql,u.getUserName(),u.getPassword());
    }

    public void setJt(JdbcTemplate jt) {
        this.jt = jt;
    }

    //删除用户
    @Override
    public void deleteUser(int id) {
        String sql="delete from user where id=?";
        jt.update(sql,id);
    }
    //更新用户
    @Override
    public void updateUser(User u) {
        String sql="update user set username=?,password=? where id=?";
        jt.update(sql,u.getUserName(),u.getPassword(),u.getId());
    }
    //根据id查询用户
    @Override
    public User selectUserById(int id) {

        String sql="select * from user where id=?";
        User user=jt.queryForObject(sql, new RowMapper<User>(){
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User();
                user.setId(resultSet.getInt(1));
                user.setUserName(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
                return user;
            }
        },id);
        return user;
    }
    //查询全部用户
    @Override
    public List<User> selectAllUser() {
        String sql="select * from user";
        List<User> userList=jt.query(sql, new RowMapper<User>() {

            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User u=new User();
                u.setId(resultSet.getInt("id"));
                u.setUserName(resultSet.getString("username"));
                u.setPassword(resultSet.getString("password"));
                return u;
            }
        });
        return userList;
    }
    //查询用户数量
    @Override
    public int selectUserCount() {
        String sql="select count(*) from user";
        int count=jt.queryForObject(sql,int.class);
        return count;
    }
}
