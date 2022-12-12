package com.example.demo.designPatterns.monitor;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

/**
 * @author wangkg
 * @Date 2021/5/26 15:33
 */
@Component
public class ExtApplicationEventPublisherAware implements ApplicationEventPublisherAware {


   /* public ExtApplicationEventPublisherAware(User user) {

    }*/

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        User user = new User("王凯光");
        System.out.println("发布的事件数据是："+user);
        applicationEventPublisher.publishEvent(user);
    }

/*    public static void main(String[] args) {
        new ExtApplicationEventPublisherAware(new User(""));
    }*/
}
