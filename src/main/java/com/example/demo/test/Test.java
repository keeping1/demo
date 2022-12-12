package com.example.demo.test;

import com.example.demo.designPatterns.monitor.User;

import java.util.*;

/**
 * @author wangkg
 * @Date 2021/6/21 10:39
 */
public class Test {
    public static void main(String[] args) {
        InterfaceTest handler = null;
        HashMap<Integer, Integer> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put(1,1);
        InterfaceTest testHalder1 = new TestHalder1();
        TestEntity handle1 = testHalder1.handle(1, stringStringHashMap);
        System.out.println("===111"+handle1);
       // TestEntity handle = handler.handle(1, stringStringHashMap);

     //   System.out.println("+++"+handle);

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, -3);
        Date time = calendar.getTime();
        System.out.println("3434343"+time);

        List<Integer> integerArrayList = new LinkedList<>();
        integerArrayList.add(112);
        integerArrayList.add(43434);
        System.out.println(integerArrayList);
        integerArrayList.add(0,4343988);
        System.out.println(integerArrayList);
        integerArrayList.add(0,434343434);
        System.out.println(integerArrayList);
    }
}
