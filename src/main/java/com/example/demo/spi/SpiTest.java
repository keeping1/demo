package com.example.demo.spi;


import org.springframework.beans.factory.BeanFactory;

import java.util.ServiceLoader;

/**
 * @author wangkg
 * @Date 2021/6/22 16:01
 */
public class SpiTest {

    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(2);

        ServiceLoader<UploadCDN> uploadCDN = ServiceLoader.load(UploadCDN.class);
        for (UploadCDN cdn : uploadCDN) {
            Class<? extends UploadCDN> aClass = cdn.getClass();
            if (aClass.getName().equals("com.example.demo.spi.AqiyiUploadCdn")) {
                cdn.upload("sss");
            }
        }
        ServiceLoader<BeanFactory> load = ServiceLoader.load(BeanFactory.class);
        for (BeanFactory beanFactory : load) {

            beanFactory.getBean("22");
        }

    }
}
