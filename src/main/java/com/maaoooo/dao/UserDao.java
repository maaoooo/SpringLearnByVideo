package com.maaoooo.dao;

import com.maaoooo.bean.User;

/**
 * @author lzr
 * @date 2020 05 10 22:03
 * @description
 */
public interface UserDao {
    //根据id查找用户
    public User selectUserById();
}
