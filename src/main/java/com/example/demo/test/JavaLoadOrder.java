package com.example.demo.test;

/**
 * @author kaiguang.wang
 * @version 1.0
 * @date 2023/1/4 9:57
 */
public class JavaLoadOrder {

    static {
        System.out.println("静态代码块");
    }

    JavaLoadOrder(){
        System.out.println("无惨构造");
    }
    {
        System.out.println("代码块");
    }



    public static void main(String[] args) {
        System.out.println("主方法");
        new JavaLoadOrder();
        new JavaLoadOrder();
        {
            System.out.println("局部代码块");
        }
    }

}
