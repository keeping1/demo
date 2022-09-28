package com.example.demo.event;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author kaiguang.wang
 * @version 1.0
 * @date 2022/7/13 14:32
 */
@Service
public class EventTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void product(){
        System.out.println("开始发布消息");
        applicationContext.publishEvent(new OrderProductEvent(this,"323232323"));
        System.out.println("订单消息处理结束");
    }

    public static void main(String[] args) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = dateTimeFormatter.format(LocalDateTime.now());

        System.out.println(format);

    }

}
