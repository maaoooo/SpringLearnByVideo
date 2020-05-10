package com.maaoooo.proxy;

import java.util.Properties;

/**
 * @author lzr
 * @date 2020 05 08 21:18
 * @description
 */
public class Test {
    public static void main(String[] args) {
        Print print=new PrintImpl();
        print.print("hi");
        //---
        ProxyHandle proxyHandle=new ProxyHandle();
        Print print1= ((Print) proxyHandle.newProxyInstance(print));
        print1.print("hi");
    }
}
