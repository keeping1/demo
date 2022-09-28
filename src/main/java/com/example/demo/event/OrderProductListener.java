package com.example.demo.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.zip.InflaterOutputStream;

/**
 * @author kaiguang.wang
 * @version 1.0
 * @date 2022/7/13 14:27
 */
@Slf4j
@Component
public class OrderProductListener implements ApplicationListener<OrderProductEvent> {


    @Override
    public void onApplicationEvent(OrderProductEvent orderProductEvent) {
        String orderId = orderProductEvent.getOrderId();
        long l = System.currentTimeMillis();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("处理订单id：{}，耗时：{}", orderId, System.currentTimeMillis() - l);
    }
}
