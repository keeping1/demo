package com.example.demo.stream;

import java.util.stream.Stream;

/**
 * @author kaiguang.wang
 * @version 1.0
 * @date 2022/7/13 13:05
 */
public class MatchTest {

    public static void main(String[] args) {
        //noneMatch 数据流中得没有一个元素与条件匹配的
        boolean result = Stream.of("aa","bb","cc","aa")
                .noneMatch(e->e.equals("aa"));
        System.out.println(result);
        //noneMatch 数据流中得任意匹配
        boolean result1 = Stream.of("aa","bb","cc","aa")
                .anyMatch(e->e.equals("aa"));
        System.out.println(result1);

        //reduce 是一个规约操作，所有的元素归约成一个，比如对所有元素求和，乘啊等
        int sum = Stream.of(0,9,8,4,5,6,-1)
                .reduce(0,(e1,e2)->e1+e2);
        System.out.println(sum);

    }

}
