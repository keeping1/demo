package com.example.demo.designPatterns.abstractFactory;

import org.springframework.context.annotation.Bean;

/**
 * 可以看出，抽象工厂和工厂方法十分类似，只不过抽象工厂里面只生产一个对象，而抽象工厂可以生产多个对象。
 *
 * 抽象工厂缺点也很明显，第一就是和工厂方法一样工厂类非常多，第二就是扩展非常麻烦，
 * 比如我现在要为每个客户类型再加一份客户特殊资料，那所有涉及到抽象工厂的工厂类都要改，是不是要疯了。。
 * @author wangkg
 * @Date 2021/7/20 14:46
 */
public class Test {
    public static void main(String[] args) {

        CustomerFactory bankPartnerFactory = new BankPartnerFactory();
        System.out.println(bankPartnerFactory.createCustomerExt());
        CustomerFactory agentFactory = new AgentFactory();
        System.out.println(agentFactory.createCustomerExt());
        CustomerFactory merchantFactory = new MerchantFactory();
        System.out.println(merchantFactory.createCustomerExt());
    }
}
