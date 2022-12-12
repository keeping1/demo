package com.example.demo.designPatterns.monitor;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author wangkg
 * @Date 2021/5/26 15:30
 */

@Component
public class EventListener implements ApplicationListener<User> {
    @Override
    public void onApplicationEvent(User user) {
        System.out.println("监听的事件："+user);
    }
}
