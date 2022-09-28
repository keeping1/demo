package com.example.demo.event;

import lombok.Data;
import lombok.ToString;
import org.springframework.context.ApplicationEvent;

/**
 * @author kaiguang.wang
 * @version 1.0
 * @date 2022/7/13 14:25
 */
@Data
@ToString
public class OrderProductEvent extends ApplicationEvent {

    private String orderId;

    public OrderProductEvent(Object source,String orderId) {
        super(source);
        this.orderId = orderId;
    }
}
