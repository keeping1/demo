package com.example.demo.stream;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author kaiguang.wang
 * @version 1.0
 * @date 2022/7/13 13:03
 */
public class FindTest {

    public static void main(String[] args) {
        Optional<String> stringOptional = Stream.of("apple", "banana", "orange", "waltermaleon", "grape")
                .parallel()
                .findAny();
        stringOptional.ifPresent(e->System.out.println(e));
    }
}
