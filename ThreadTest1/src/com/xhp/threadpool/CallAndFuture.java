package com.xhp.threadpool;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by xhp on 2016/10/8.
 */
public class CallAndFuture {

    public static void main(String[] a){
        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        Future<String> future = threadPool.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "hello";
            }
        });
        System.out.println("等待结果");
        try {
            System.out.println("拿到结果:"+future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        ExecutorService threadPool2 = Executors.newFixedThreadPool(10);
        CompletionService<Integer> completionService = new ExecutorCompletionService<Integer>(threadPool2);
        for (int i = 0; i < 10; i++) {
            final int seq = i;
            completionService.submit(new Callable<Integer>(){
                @Override
                public Integer call() throws Exception {
                    Thread.sleep(new Random().nextInt(5000));
                    return seq;
                }
            });
        }
        for(int i=0;i<10;i++){
            try {
                System.out.println(
                        completionService.take().get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
