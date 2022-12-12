package com.example.demo.factoryBean;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author kaiguang.wang
 * @version 1.0
 * @date 2022/2/28 23:45
 */
public class ApplicationContextTest implements ApplicationContextAware {

    public static ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ApplicationContextTest.applicationContext = applicationContext;
    }

    public static Object  getBean(String name){
     return applicationContext.getBean(name);
    }
}
