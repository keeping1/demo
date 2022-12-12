package com.example.demo.test;

import com.example.demo.designPatterns.monitor.User;

import java.util.HashMap;

/**
 * @author wangkg
 * @Date 2021/6/21 10:31
 */
public interface InterfaceTest {
    /**
     * 路由转化
     * @param i
     * @param hashMap
     * @return
     */
    TestEntity handle(int i, HashMap<Integer ,Integer> hashMap);
}
