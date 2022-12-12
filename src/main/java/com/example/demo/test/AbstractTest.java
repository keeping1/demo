package com.example.demo.test;

import com.example.demo.designPatterns.monitor.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.util.HashMap;

/**
 * @author wangkg
 * @Date 2021/6/21 10:30
 */
public abstract class AbstractTest implements InterfaceTest{
    protected Logger logger = LoggerFactory.getLogger(getClass());

}
