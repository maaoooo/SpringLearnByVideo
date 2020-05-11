package com.maaoooo.dao;

import com.maaoooo.bean.User;

import java.util.List;

/**
 * @author lzr
 * @date 2020 05 10 22:03
 * @description
 */
public interface UserDao {
    //增
    public void saveUser(User u);
    //删
    public void deleteUser(int id);
    //改
    public void updateUser(User u);
    //查
    //根据id查找用户
    public User selectUserById(int id);
    //查找全部用户
    public List<User> selectAllUser();
    //查找用户数量
    public int selectUserCount();
}
