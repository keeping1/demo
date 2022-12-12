package com.example.demo.test;

import com.example.demo.designPatterns.monitor.User;

import java.util.HashMap;

/**
 * @author wangkg
 * @Date 2021/6/21 10:35
 */
public class TestHalder1 extends AbstractTest {

    @Override
    public TestEntity handle(int i, HashMap<Integer, Integer> hashMap) {
        TestEntity user = new TestEntity();

        user.setName("王凯光1");
        return user;
    }
}
