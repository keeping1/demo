package com.example.demo.proxy.staticProxy;

import org.aspectj.weaver.ast.Var;

/**
 * 律师类
 * @author kaiguang.wang
 * @version 1.0
 * @date 2022/2/28 21:24
 */
public class LawyerSpeak implements Speak {

    ZhanSanSpeak zhanSanSpeak = new ZhanSanSpeak();


    @Override
    public void speak() {
        System.out.println("律师的法律条文");
        zhanSanSpeak.speak();
    }
}
