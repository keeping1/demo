package com.example.demo.annotation.ImportAnnotation;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/**
 * @author wangkg
 * @Date 2021/9/6 10:32
 */
public class ImportTest {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(ImportConfig.class);
        ImportUserService bean = annotationConfigApplicationContext.getBean(ImportUserServiceImpl.class);
        bean.save(null);
        annotationConfigApplicationContext.close();
    }
}
