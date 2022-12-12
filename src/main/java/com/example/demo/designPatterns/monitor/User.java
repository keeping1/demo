package com.example.demo.designPatterns.monitor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.ApplicationEvent;

/**
 * @author wangkg
 * @Date 2021/5/26 15:30
 */
public class User extends ApplicationEvent {
    private String name;

    public User(String name) {
        super(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(Object source) {
        super(source);
    }

}
