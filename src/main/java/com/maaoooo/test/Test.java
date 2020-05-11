package com.maaoooo.test;

import com.maaoooo.service.UserService;
import com.maaoooo.service.UserServiceImpl;
import com.maaoooo.service.UserServiceProxy;

/**
 * @author lzr
 * @date 2020 05 08 22:23
 * @description
 */
public class Test {
    public static void main(String[] args) {
        UserService userService=new UserServiceImpl();
        UserServiceProxy userServiceProxy=new UserServiceProxy();
        UserService userService1=((UserService) userServiceProxy.newProxyInstance(userService));
        userService1.save();
        userService1.delect();
        userService1.update();
        userService1.find();
    }
    public void test() {
    }
}
