package com.xhp.thread;

/**
 * Created by xhp on 2016/10/6.
 */

public class TraditionalThread {

    public static void main(String[] ars){
        Thread t1 = new Thread(){
            @Override
            public void run() {
                while (true){
                System.out.println("1:"+Thread.currentThread().getName());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        };
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("2:"+Thread.currentThread().getName());
                }
            }
        });
        t2.start();
    }

}

