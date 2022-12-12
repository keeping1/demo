package com.example.demo.designPatterns.chainOfResponsibilityPattern;

/**
 * @author wangkg
 * @Date 2021/8/10 18:09
 */
public class Test {
    public static void main(String[] args) {
       // MemberService memberService = new MemberService();
        MemberService1 memberService = new MemberService1();
        memberService.login("tom","666");
    }
}
