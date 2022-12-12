package com.example.demo.annotation.ImportAnnotation;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author wangkg
 * @Date 2021/9/6 11:51
 */
public class UserServiceBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        BeanDefinitionBuilder userService = BeanDefinitionBuilder.rootBeanDefinition(ImportUserServiceImpl.class);
        //通过registry就可以注入到容器里
        registry.registerBeanDefinition("userService", userService.getBeanDefinition());
    }
}
