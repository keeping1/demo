package com.example.demo.spi;

/**
 * @author wangkg
 * @Date 2021/6/22 15:59
 */
public class AqiyiUploadCdn implements UploadCDN {
    @Override
    public void upload(String url) {
        System.out.println("===实现爱奇艺上传："+url);
    }
}
