package com.maaoooo.aop;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author lzr
 * @date 2020 05 10 15:40
 * @description
 */
public class MyAdvice {
    //before 前置通知 在目标方法前调用
    public void before(){
        System.out.println("before");
    }
    //after 最终通知 无论是否出现异常都会执行 后置通知
    public  void after(){
        System.out.println("after");
    }
    //afterReturning成功通知
    public  void afterReturning(){
        System.out.println("afterReturning");
    }
    //afterThrowing异常通知
    public void afterThrowing(){
        System.out.println("afterThrowing");
    }
    //环绕通知 需要我们手动调用目标方法 并且可以设置通知
    public void around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("aroundBefore");
        Object o=pjp.proceed();
        System.out.println("aroundAfter");
    }
}
