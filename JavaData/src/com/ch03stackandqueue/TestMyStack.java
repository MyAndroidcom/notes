package com.ch03stackandqueue;

/**
 * Created by xhp on 2016/10/18.
 */
public class TestMyStack {

    public static void main(String[] args) {
        MyStack mystack = new MyStack();
        mystack.push(100);
        mystack.push(199);
//        mystack.pop();
        System.out.println(mystack.pop());
        System.out.println(mystack.peek());

    }

}
