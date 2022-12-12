package com.example.demo.test;

import java.lang.invoke.VarHandle;

/**
 * @author wangkg
 * @Date 2021/5/30 17:52
 */
public class SyncMethod {
   static Object object = new Object();

    public static void main(String[] args) {

    }

    public void xxx(){
        synchronized (object){
            System.out.println("======");
        }


    }
}
