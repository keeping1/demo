package com.example.demo.stream;

import java.util.stream.Stream;

/**
 * peek 挑选 ，将元素挑选出来，可以理解为提前消费
 * @author kaiguang.wang
 * @version 1.0
 * @date 2022/7/13 10:34
 */
public class PeekTest {


    public static void main(String[] args) {


        Stream.of(2,1,3,6,4,9,6,8,0)
                .sorted()
                .forEach(e->System.out.println(e));


        User w = new User("w",10);
        User x = new User("x",11);
        User y = new User("y",12);

        Stream.of(w,x,y)
                .peek(e->{e.setName(e.getAge()+e.getName());}) //重新设置名字 变成 年龄+名字
                .forEach(e->System.out.println(e.toString()));

    }


    static class User {

        private String name;

        private int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "User{" + "name='" + name + ",age=" + age +'}';
        }
    }
}
