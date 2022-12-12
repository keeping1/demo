package com.example.demo.factoryBean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author kaiguang.wang
 * @version 1.0
 * @date 2022/2/28 23:41
 */
public class FactoryBeanUser implements FactoryBean<WkgUser> {
    @Override
    public WkgUser getObject() throws Exception {
        WkgUser wkgUser = new WkgUser();
        wkgUser.setAge(26);
        wkgUser.setName("王凯光");
        return wkgUser;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }
}
