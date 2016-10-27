package com.xhp.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 线程范围内共享数据
 */
public class ThreadScopeShareData {
    private static int data = 0;
    static Map<Thread,Integer> threadMap = new HashMap<>();
    public static void main(String[] at) {

        for (int i = 0; i < 4; i++) {

            new Thread(new Runnable() {
                @Override
                public void run() {
                    data = new Random().nextInt();
                    System.out.println(Thread.currentThread().getName() + ":has put data" + data);
                    threadMap.put(Thread.currentThread(), data);
                    new A().get();
                    new B().get();
                }
            }).start();
        }
    }
    static class A{
        void get(){
        int data = threadMap.get(Thread.currentThread());
            System.out.println("A from currentThread data:"+ data);
        }
    }
    static class B{
        void get(){
        int data = threadMap.get(Thread.currentThread());
            System.out.println("B from currentThread data:"+data);
        }
    }
}
