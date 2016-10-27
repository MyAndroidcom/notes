package com.ch03stackandqueue;

/**
 * Created by xhp on 2016/10/18.
 */
public class TestMyCycleQueue {
    public static void main(String[] args) {
        MyCycleQueue myCycleQueue = new MyCycleQueue(4);
        myCycleQueue.insert(120);
        myCycleQueue.insert(1);
        myCycleQueue.insert(20);
        myCycleQueue.insert(920);
        myCycleQueue.insert(320);
        System.out.println(myCycleQueue.remove());
        System.out.println(myCycleQueue);
    }
}
