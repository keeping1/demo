package com.example.demo.stream;

import org.junit.Test;

import java.util.stream.Stream;

/**
 * 转换操作符，把比如A->B，这里默认提供了转int，long，double的操作符。
 * @author kaiguang.wang
 * @version 1.0
 * @date 2022/7/12 10:23
 */
public class map {

    @Test
    public void mapToInt(){
        Stream.of("ap","aw","ae","aq")
                .mapToInt(String::length).forEach(System.out::println);
    }
    @Test
    public void mapTest(){
        Stream.of("ap","aw","ae","aq")
                .map(String::length).forEach(System.out::println);
    }
    @Test
    public void mapToDouble(){
        Stream.of("ap","aw","ae","aq")
                .mapToDouble(String::length).forEach(System.out::println);
    }


}
