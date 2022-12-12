package com.example.demo.proxy.staticProxy;

/**
 * @author kaiguang.wang
 * @version 1.0
 * @date 2022/2/28 21:22
 */
public class ZhanSanSpeak implements Speak{
    @Override
    public void speak() {
        System.out.println("张三说话");
    }
}
