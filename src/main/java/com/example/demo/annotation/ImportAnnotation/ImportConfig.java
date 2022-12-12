package com.example.demo.annotation.ImportAnnotation;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author wangkg
 * @Date 2021/9/6 10:46
 */
@Configuration
@EnableConfigurationProperties(value = Dept.class)
//@Import(value = UserServiceBeanDefinitionRegistrar.class)
public class ImportConfig {
}
