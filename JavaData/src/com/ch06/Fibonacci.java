package com.ch06;

/**
 * Created by xhp on 2016/10/18.
 */
public class Fibonacci {
    public static int getNumber(int n){
        if(n == 1){
            return 0;
        }else if(n == 2){
            return 1;
        }else {
            return getNumber(n-1)+getNumber(n-2);
        }
    }

    public static void main(String[] args) {
        System.out.println(getNumber(8));
    }
}
