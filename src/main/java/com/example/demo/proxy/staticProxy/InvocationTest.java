package com.example.demo.proxy.staticProxy;

import com.example.demo.proxy.dynamicProxy.InteceptorLawyer;
import com.example.demo.proxy.dynamicProxy.LawyerProxy;
import net.sf.cglib.proxy.Enhancer;

import java.lang.reflect.Proxy;

/**
 * @author wangkg
 * @Date 2021/6/21 15:38
 */
public class InvocationTest {
    public static void main(String[] args) {

        //DynamicPermissionProxy dynamicPermissionProxy = new DynamicPermissionProxy();
//        dynamicPermissionProxy.invoke()

        Speak zhanSanSpeak = new LawyerSpeak();
        zhanSanSpeak.speak();

        //jdk如果没有实现接口就没发被代理
        System.out.println("----jdk动态代理");
        LawyerProxy lawyerProxy = new LawyerProxy(new ZhanSanSpeak());
        Speak speak = (Speak)Proxy.newProxyInstance(InvocationTest.class.getClassLoader(), new Class[]{Speak.class}, lawyerProxy);
        speak.speak();

        System.out.println("====cglib---");
        InteceptorLawyer inteceptorLawyer = new InteceptorLawyer(new LisiSpeak());
        LisiSpeak o =(LisiSpeak) Enhancer.create(LisiSpeak.class, inteceptorLawyer);
        o.speak();

    }
}
