package com.example.demo.thread.thread;

import org.aspectj.weaver.ast.Var;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author wangkg
 * @Date 2021/8/31 13:52
 */
public class CompletableFutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        completableFuture.complete(ce());
        System.out.println("===主线程结束===");
        System.out.println("===返回结果"+completableFuture.get());

int x=20,y=30;
boolean b;
b = x>50 && y>60||x>50&&y<-60||x<-50&&y>60||x<-50&&y<-60;
        System.out.println("dsdsd:"+b);


    }

    public static String ce(){

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "43434";
    }



}
