package com.example.demo.designPatterns.chainOfResponsibilityPattern;

/**
 * @author wangkg
 * @Date 2021/8/10 18:09
 */
public class MemberService {

    public void login(String username, String password){
        Handler validateHandler = new ValidateHandler();
        Handler loginHandler = new LoginHandler();
        Handler authHandler = new AuthHandler();

        validateHandler.next(loginHandler);
        loginHandler.next(authHandler);

        validateHandler.doHandler(new Member(username,password));
    }
}
