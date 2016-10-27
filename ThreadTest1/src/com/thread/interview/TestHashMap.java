package com.thread.interview;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by xhp on 2016/10/25.
 * HashMap并发问题
 */
public class TestHashMap {

    private static final Executor EXECUTOR = Executors.newFixedThreadPool(20);

    public static void main(String[] args) {
        final Map<String, String> map = new HashMap();
        map.put("laodu", "handman");
        final Random random = new Random();
        while (true) {
            EXECUTOR.execute(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 1000; i++) {
                        try {
                            TimeUnit.MILLISECONDS.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        //取
                        for (String key : map.keySet()) {
                            System.out.println(Thread.currentThread().getName() + ":" + key);
                        }
                    }
                }
            });
            for (int i = 0; i < 100; i++) {
                EXECUTOR.execute(new Runnable() {
                    @Override
                    public void run() {
                        for (int j = 0; j < 1000; j++) {
                            try {
                                TimeUnit.MILLISECONDS.sleep(1);
                            } catch (InterruptedException e) {
                                System.err.println("t1 catch the InterruptedException...");
                            }
                            //存
                            int key = random.nextInt(1000);
                            map.put(String.valueOf(key), String.valueOf(key));
                        }
                    }
                });

            }
        }
    }
}
/*
* 一笔交易支付事件过来，事件类型为HashMap，我们需要对卡信息，IP信息等进行信息补全，通过线程池并发执行信息补全的过程中，在每个线程内部执行了map.put(key,value)的操作，
* 因此在高并发情况下会可能会抛出异常Java.util.ConcurrentModificationException。
*如果此时在线程中执行map.keySet() 操作，遍历map中的数据，那么出现异常java.util.ConcurrentModificationException的概率就很高了。
*
* 使用HashMap可能出现的问题
* a. put 的数据丢失。
  b. remove 的数据未被清除，仍然存在。
  c. HashMap resize 导致存在性能问题。
  d. get 数据时出现死循环。

  解决：
  1.synchronizedMap
  2.currentHashMap
* */