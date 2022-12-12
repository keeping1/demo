package com.example.demo.factoryBean;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;

/**
 * @author kaiguang.wang
 * @version 1.0
 * @date 2022/2/28 23:43
 */
public class FactoryBeanUserTest {

    @Test
    public void sayHelloTest() {
        WkgUser wkgUser = (WkgUser)ApplicationContextTest.getBean("wkgUser");
        System.out.println(wkgUser);
    }

}
