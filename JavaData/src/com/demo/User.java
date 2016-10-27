package com.demo;

/**
 * Created by xhp on 2016/10/22.
 */
public class User extends Person {

    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {
        User[] user = new User[]{new User("asdf",2),new User("aa",88)};
        User[] user2 = {new User("12",2),new User("we",123)};
        User[] uaer3 = new User[10];
        int[] arr = new int[]{2,154,5};
    }
}
