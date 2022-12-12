package com.example.demo.proxy.dynamicProxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * cglib
 * @author kaiguang.wang
 * @version 1.0
 * @date 2022/2/28 21:46
 */
public class InteceptorLawyer implements MethodInterceptor {

    private Object object;

    public InteceptorLawyer(Object object){
        this.object = object;

    }
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {

        if(method.getName().equals("speak")){
            System.out.println("===引用cglib动态条文");
            method.invoke(object,args);
        }
        return null;
    }
}
