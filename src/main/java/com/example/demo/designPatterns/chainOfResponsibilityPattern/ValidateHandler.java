package com.example.demo.designPatterns.chainOfResponsibilityPattern;

import org.apache.commons.lang3.StringUtils;

/**
 * @author wangkg
 * @Date 2021/8/10 17:59
 */
public class ValidateHandler extends Handler {
    @Override
    public void doHandler(Member member) {
        if(StringUtils.isEmpty(member.getLoginName()) ||
                StringUtils.isEmpty(member.getLoginPass())){
            System.out.println("用户名和密码为空");
            return;
        }
        System.out.println("用户名和密码不为空，可以往下执行");
        next.doHandler(member);
    }
}
