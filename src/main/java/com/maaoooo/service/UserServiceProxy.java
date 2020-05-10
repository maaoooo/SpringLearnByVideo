package com.maaoooo.service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author lzr
 * @date 2020 05 08 22:03
 * @description
 */
public class UserServiceProxy implements InvocationHandler {
    private Object target;

    public Object newProxyInstance(Object target){
        this.target=target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("开启事务");
        method.invoke(target,args);
        System.out.println("提交/回滚");
        return null;
    }
}
