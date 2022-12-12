package com.example.demo.designPatterns.chainOfResponsibilityPattern;

/**
 * @author wangkg
 * @Date 2021/8/10 18:08
 */
public class LoginHandler extends Handler {
    @Override
    public void doHandler(Member member) {
        System.out.println("登录成功！");
        member.setRoleName("管理员");
        next.doHandler(member);
    }
}
