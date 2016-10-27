package com.ch03stackandqueue;

/**
 * Created by xhp on 2016/10/18.
 */
public class TestMyqueue {
    public static void main(String[] args) {
        Myqueue myqueue = new Myqueue(4);
        myqueue.insert(10);
        myqueue.insert(12);
        myqueue.insert(123);
        myqueue.insert(0);
        System.out.println(myqueue.peek());
        System.out.println(myqueue.isFull());
        while (!myqueue.isEmpty()){
            //从对头删除
            System.out.print(myqueue.remove() + " ");
        }
    }
}
