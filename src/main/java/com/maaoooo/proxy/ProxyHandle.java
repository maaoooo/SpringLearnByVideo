package com.maaoooo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author lzr
 * @date 2020 05 08 21:02
 * @description
 */
public class ProxyHandle implements InvocationHandler {
    private Object targeObject;
    public Object newProxyInstance(Object targeObject){
        this.targeObject=targeObject;
        return Proxy.newProxyInstance(targeObject.getClass().getClassLoader(),targeObject.getClass().getInterfaces(),this);
    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("记录日志");
        return method.invoke(targeObject,args);
    }
}
