package com.example.demo.designPatterns.chainOfResponsibilityPattern;

/**
 * @author wangkg
 * @Date 2021/8/10 18:10
 */
public class MemberService1 {
    public void login(String loginName,String loginPass){

        Handler.Builder builder = new Handler.Builder();

        builder.addHandler(new ValidateHandler())
                .addHandler(new LoginHandler())
                .addHandler(new AuthHandler());

        builder.build().doHandler(new Member(loginName,loginPass));
    }
}
