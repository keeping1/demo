package com.example.demo.annotation.ImportAnnotation;

/**
 * @author wangkg
 * @Date 2021/9/6 10:32
 */
public class ImportUserServiceImpl implements ImportUserService {
    @Override
    public int save(ImportUser user) {
        System.out.println("调用了当前方法");
        return 1;
    }
}
