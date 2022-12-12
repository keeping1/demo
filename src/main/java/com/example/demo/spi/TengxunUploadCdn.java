package com.example.demo.spi;

/**
 * @author wangkg
 * @Date 2021/6/22 15:59
 */
public class TengxunUploadCdn implements UploadCDN {
    @Override
    public void upload(String url) {
        System.out.println("===实现腾讯上传");
    }
}
