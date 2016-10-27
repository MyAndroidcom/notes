package com.xhp.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by xhp on 2016/10/8.
 */
public class ThreadPoolTest {

    static int sum = 0;
    public static void main(String[] ss){
        //缓存的线程池
        ExecutorService threadPool2 = Executors.newCachedThreadPool();
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            final int task = i;
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10; j++) {
                        try {
                            Thread.sleep(20);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName()+"  is looping of  " + j + " for  task of " + task);
                    }
                }
            });
            System.out.println("执行次数===========================:"+sum);
        }
    }

}
