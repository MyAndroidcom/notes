package com.io;

/**
 * Created by xhp on 2016/10/24.
 */
public class Demo5 {
    public static void main(String[] args) {
        int test = test(5);
        System.out.println(test);
    }

    public static int print(int num) {
        if (num == 1) {
            return 1;
        } else {
            return num * print(num - 1);
        }
    }

    public static int test(int num){
        int result = 1;
        while (num > 0){
            result = result * num;
            num--;
        }
        return result;
    }
}
