package com.example.demo.proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author kaiguang.wang
 * @version 1.0
 * @date 2022/2/28 21:34
 */
public class LawyerProxy implements InvocationHandler {

    private Object object;

    public LawyerProxy(Object object){
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if (method.getName().equals("speak")){
            System.out.println("运用动态代理的法律条文");
            method.invoke(object,args);
        }

        return null;
    }
}
