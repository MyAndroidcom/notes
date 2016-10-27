package com.xhp.thread;

import org.junit.Test;

import java.util.Random;

/**
 * Created by xhp on 2016/10/7.
 */
public class TestDemo1 {
    @Test
    public void test() {
        int data = new Random().nextInt();
        String str="asjiosg";
        str.length();
        String[] strr = {"as","asd"};
        int length = strr.length;
        System.out.println(data);
    }

    public static void change3(int i){
        i = 100;
    }

    public static void change(String str){
        str = "123";
    }

    public static void change2(StringBuilder str){
        str.append("123");
    }

    public static void main(String[] args) {
        StringBuilder str = new StringBuilder("456");
        change2(str);
        System.out.println(str);
    }

}
