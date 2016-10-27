package com.thread.interview;

import java.util.Random;

/**
 *
 * ThreadLocal内部实现原理

     首先，在每个线程Thread内部有一个ThreadLocal.ThreadLocalMap类型的成员变量threadLocals，这个threadLocals就是用来存储实际的变量副本的，键值为当前ThreadLocal变量，value为变量副本（即T类型的变量）。

 　　初始时，在Thread里面，threadLocals为空，当通过ThreadLocal变量调用get()方法或者set()方法，就会对Thread类中的threadLocals进行初始化，并且以当前ThreadLocal变量为键值，以ThreadLocal要保存的副本变量为value，存到threadLocals。

 　　然后在当前线程里面，如果要使用副本变量，就可以通过get方法在threadLocals里面查找。
 */
public class ThreadLocalTest {

    private ThreadLocal<MyThreadScopeData> threadLocal = new ThreadLocal<>();
    private static ThreadLocal<Integer> xx = new ThreadLocal<>();

    public static void main(String[] a) {
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int data = new Random().nextInt();
                    System.out.println(Thread.currentThread().getName() + "has put data" + data);
                    xx.set(data);
                    MyThreadScopeData.getInstance().setName("name" + data);
                    MyThreadScopeData.getInstance().setAge(data);
                    new A().get();
                    new B().get();
                }
            }).start();
        }

    }

    static class A{
        void get(){
        int data = xx.get();
            System.out.println("A from " + Thread.currentThread().getName()
                    + " get data :" + data);
            MyThreadScopeData myData = MyThreadScopeData.getInstance();
            System.out.println("A from "+Thread.currentThread().getName()+" getMyData: " + myData.getName() + "," +
                    myData.getAge());
        }
    }
    static class B{
    void get(){
        int data = xx.get();
        System.out.println("B from "+ Thread.currentThread().getName()+data);
        MyThreadScopeData myData = MyThreadScopeData.getInstance();
        System.out.println("B from "+ Thread.currentThread().getName()+"getMyData:" +myData.getAge());
    }

    }

    static class MyThreadScopeData {
        private MyThreadScopeData() {
        }

        private static ThreadLocal<MyThreadScopeData> map = new ThreadLocal<>();

        public static MyThreadScopeData getInstance() {
            MyThreadScopeData instance = map.get();
            if (instance == null) {
                instance = new MyThreadScopeData();
                map.set(instance);
            }
            return instance;
        }

        private String name;
        private int age;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {

            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
