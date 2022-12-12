package com.example.demo.spi;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author wangkg
 * @Date 2021/6/22 15:58
 */
public interface UploadCDN {

    /**
     * 上传接口
     * @param url
     */
    @Autowired
    void upload(String url);
}
