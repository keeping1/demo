package com.example.demo.thread.threadLocal;


import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wangkg
 * @Date 2021/6/18 11:35
 */
public class ThreadLocalTest {


    private final int threadLocalHashCode = nextHashCode();

    private static AtomicInteger nextHashCode = new AtomicInteger();

    private static final int HASH_INCREMENT = 0x61c88647;

    private static int nextHashCode() {
        return nextHashCode.getAndAdd(HASH_INCREMENT);
    }
    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
    public static void main(String[] args) {

        HashMap<Integer, Integer> integerIntegerHashMap = new HashMap<>();
        integerIntegerHashMap.put(1,2);
        Integer put = integerIntegerHashMap.put(1, 1);
        System.out.println("返回"+put);

        threadLocal.set(1);
        Thread t = new Thread(()->{
            threadLocal.set(2);
            System.out.println("子线程:" + threadLocal.get());
        });
        t.start();
        System.out.println("主线程:" + threadLocal.get());


        ThreadLocalTest a = new ThreadLocalTest();
        ThreadLocalTest b = new ThreadLocalTest();
        ThreadLocalTest c = new ThreadLocalTest();
        for (int i = 0; i < 2; i++) {
            System.out.println("第" + (i + 1) + "次打印");
            int threadLocalHashCode = a.threadLocalHashCode;
            System.out.println(threadLocalHashCode);
            System.out.println(b.threadLocalHashCode);
            System.out.println(c.threadLocalHashCode);
        }


    }
}
