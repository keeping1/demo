package com.example.demo.test;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;

/**
 * @author wangkg
 * @Date 2021/10/20 10:42
 */
public class CollectTest {

    // 原集合
    private static final List<String> OLD_LIST = Arrays.asList(
            "唐僧,悟空,八戒,沙僧,曹操,刘备,孙权".split(","));
    /**
     * 拆分集合
     */
    public static void main(String[] args) {
        List<List<String>> partition = Lists.partition(OLD_LIST, 5);
        for (List<String> stringList : partition) {
            System.out.println("数据："+ JSON.toJSONString(stringList)+"长度"+stringList.size());

        }
    }
}
