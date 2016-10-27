package com.ch06;

/**
 * Created by xhp on 2016/10/18.
 */
public class Recursion {

    public static int getNumber(int n){
        int total = 0;
        while (n > 0){
            total = total + n;
            n--;
        }
        return total;
    }
    public static int getNumberByRe(int n){
        if(n == 1){
            return 1;
        }else{
            return n + getNumberByRe(n - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(getNumber(4));
        System.out.println(getNumberByRe(4));
    }
}
