package com.example.demo.lock.reentrantLock;

import org.hibernate.proxy.map.MapLazyInitializer;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author kaiguang.wang
 * @version 1.0
 * @date 2022/3/21 22:45
 */
public class ReentrantLockTest {
    public static void main(String[] args) {

        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put(1,2);



        Lock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
        reentrantLock.unlock();
    }


}
