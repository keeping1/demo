package com.example.demo.test;

import org.apache.commons.lang.time.StopWatch;

import java.util.Arrays;
import java.util.Base64;

/**
 * @author kaiguang.wang
 * @version 1.0
 * @date 2022/10/13 13:24
 */
public class StopWatchTest {

    public static void main(String[] args) {

        StopWatch stopWatch = new StopWatch();
            stopWatch.start();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //Some Real Business Logic
            stopWatch.stop();
        System.out.println(stopWatch);
        byte[] bytes = "hello world".getBytes();

        System.out.println(Arrays.toString(bytes));

        System.out.println(new String(bytes));

    }
}
