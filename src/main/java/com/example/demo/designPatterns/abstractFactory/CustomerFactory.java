package com.example.demo.designPatterns.abstractFactory;

/**
 * @author wangkg
 * @Date 2021/7/20 14:41
 */
public interface CustomerFactory {

    Customer createCustomer(String type, String name);

    CustomerExt createCustomerExt();
}
