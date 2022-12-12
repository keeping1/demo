package com.example.demo.designPatterns.abstractFactory;

/**
 * @author wangkg
 * @Date 2021/7/20 14:44
 */
public class BankPartnerFactory implements CustomerFactory {
    @Override
    public Customer createCustomer(String type, String name) {
        return null;
    }

    @Override
    public CustomerExt createCustomerExt() {
        return new BankPartnerExt();
    }
}
