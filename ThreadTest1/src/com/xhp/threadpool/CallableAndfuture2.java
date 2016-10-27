package com.xhp.threadpool;

import org.junit.Test;

import java.util.concurrent.*;

/**
 *  可以看出RunnableFuture继承了Runnable接口和Future接口，而FutureTask实现了RunnableFuture接口。所以它既可以作为Runnable被线程执行，
 *  又可以作为Future得到Callable的返回值。
 *  http://mp.weixin.qq.com/s?src=3&timestamp=1475994891&ver=1&signature=HqFKTw3daqyi2sIMgtVjIBvq*0dbPuUQJTaSarETf7mNhmAuvD7hlWTtooHSyoaaW4EUkcFVW9lmL0nRtAyDJ3AIbf8yF5-A9EjkTU82dLH1d*G5yJefpY*OqT7mhqIqVVKQYQhQpp0xZ4CJO**vpzdwTFsc8VZC2NDXiLXlYfo=
 */
public class CallableAndfuture2 {

    //使用Callable+Future获取结果
    @Test
    public void test1(){
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<Integer> submit = executor.submit(new Task());
        executor.shutdown();

        try {
            System.out.println("task运行结果:"+submit.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
    class Task implements Callable<Integer>{

        @Override
        public Integer call() throws Exception {

            System.out.println("子线程在计算结果");
            Thread.sleep(2000);
            int sum = 0;
            for (int i = 0; i < 100; i++) {
                sum += i;
            }
            return sum;
        }
    }
    //callable+futureTask获取执行结果
    @Test
    public void test2(){
        ExecutorService exector = Executors.newCachedThreadPool();
        FutureTask futureTask = new FutureTask(new Task());
        exector.submit(futureTask);
        exector.shutdown();
        try {
            System.out.print(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
