package com.maaoooo.test;

import com.maaoooo.bean.User;
import com.maaoooo.dao.UserDao;
import com.maaoooo.dao.UserDaoImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lzr
 * @date 2020/5/11 10:06:08
 * @description
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:ApplicationContext.xml")
public class JdbcTest {
    //通过id查找用户
    @Test
    public void test1() {
        UserDao userDao=new UserDaoImpl();
        User user=userDao.selectUserById(5);
        System.out.println(user);
    }
    //增
    @Test
    public void test2() {
        UserDao userDao=new UserDaoImpl();
        User user = new User();
        user.setUserName("996");
        user.setPassword("777");
        userDao.saveUser(user);
    }
    //删
    @Test
    public void test3(){
        UserDao userDao=new UserDaoImpl();
        userDao.deleteUser(6);
    }
    //改
    @Test
    public void test4(){
        UserDao userDao=new UserDaoImpl();
        User user = new User(7,"BKB","wudi");
        userDao.updateUser(user);
    }
    //查找全部用户
    @Test
    public void test5(){
        UserDao userDao=new UserDaoImpl();
        List<User> userList=new ArrayList<User>();
        userList=userDao.selectAllUser();
        for (User user : userList) {
            System.out.println(user);
        }
    }
    //查看用户数量
    @Test
    public void test6(){
        UserDao userDao=new UserDaoImpl();
        int count=userDao.selectUserCount();
        System.out.println("用户数量是："+count+"个.");
    }
}
