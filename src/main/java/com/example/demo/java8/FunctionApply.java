package com.example.demo.java8;

import com.sun.jdi.PathSearchingVirtualMachine;
import lombok.Data;

import java.util.function.Function;

/**
 * @author wangkg
 * @Date 2021/9/10 14:49
 */
public class FunctionApply {


    @Data
    static
    class UserA {
        String name;
    }

    @Data
    static
    class UserB {
        String name;
    }


    public static void main(String[] args) {

        Function<UserA, UserB> function = change();

        UserA userA = new UserA();
        userA.setName("wkg");
        UserB apply = function.apply(userA);
        System.out.println(apply);
    }

    public static Function<UserA, UserB> change(){
        Function<UserA, UserB> function = (data) -> {
            UserB userB = new UserB();
            userB.setName(data.getName());
            return userB;
        };
        return function;
    }


}
