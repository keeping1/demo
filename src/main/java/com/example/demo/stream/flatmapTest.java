package com.example.demo.stream;

import org.junit.Test;

import java.util.stream.Stream;

/**
 * flatmap 作用就是将元素拍平拍扁 ，将拍扁的元素重新组成Stream，并将这些Stream 串行合并成一条Stream
 * @author kaiguang.wang
 * @version 1.0
 * @date 2022/7/12 10:31
 */
public class flatmapTest {

    @Test
    public void flatMapReplace(){
        Stream.of("a-b-c-d","e-f-i-g-h")
                .flatMap(e->Stream.of(e.split("-")))
                .forEach(System.out::println);
    }

    @Test
    public void flatMap(){
        Stream.of("a-b-c-d","e-f-i-g-h")
                .flatMap(e->Stream.of(e.replace("-","")))
                .forEach(System.out::println);
    }

}
