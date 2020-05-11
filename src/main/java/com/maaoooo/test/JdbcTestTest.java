package com.maaoooo.test;

import com.maaoooo.bean.User;
import com.maaoooo.dao.UserDao;
import com.maaoooo.dao.UserDaoImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:ApplicationContext.xml")
public class JdbcTestTest {
    @Autowired
    private UserDaoImpl userDao;
    //通过id查找用户
    @Test
    public void test1() {
        User user=userDao.selectUserById(5);
        System.out.println(user);
    }
    //增
    @Test
    public void test2() {
        User user = new User();
        user.setUserName("996");
        user.setPassword("777");
        userDao.saveUser(user);
    }
    //删
    @Test
    public void test3(){
        userDao.deleteUser(6);
    }
    //改
    @Test
    public void test4(){
        User user = new User(7,"BKB","wudi");
        userDao.updateUser(user);
    }
    //查找全部用户
    @Test
    public void test5(){
        List<User> userList=new ArrayList<User>();
        userList=userDao.selectAllUser();
        for (User user : userList) {
            System.out.println(user);
        }
    }
    //查看用户数量
    @Test
    public void test6(){
        int count=userDao.selectUserCount();
        System.out.println("用户数量是："+count+"个.");
    }
}