package com.demo;

import org.junit.Test;

/**
 * Created by xhp on 2016/10/18.
 */
public class demo1 {

    @Test
    public void test(){
        int i = 0;
        int k = i++ + ++i;  //k=2 i=2
        System.out.println("k============"+k);
        System.out.println("i============"+i);
        int j = i-- + --i;  //j=2 i=0
        System.out.println("i==========="+i);
        System.out.println("j==========="+j);
    }

    public static void main(String[] args) {
        Student student = new Student("大智",12414);
        Student ss = student;
//        ss.setName(null);
        ss = null;
        System.out.println(ss);
        System.out.println(student);
    }
}
