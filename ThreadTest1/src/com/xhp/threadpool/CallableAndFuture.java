package com.xhp.threadpool;

import java.util.concurrent.*;

/**
 * Created by xhp on 2016/10/9.
 */

//callable是一个接口，Callable用于产生结果，Future用于获取结果。
public class CallableAndFuture {
        public static void main(String[] aa) throws ExecutionException, InterruptedException {
            ExecutorService pool = Executors.newSingleThreadExecutor();
            Callable cc = new MyCallable();
            Future ff = pool.submit(cc);//执行任务并放在future中
            System.out.println(ff.get());
            pool.shutdown();

        }
        static class MyCallable implements Callable<Integer>{

            @Override
            public Integer call() throws Exception {
                int sum = 0;
                for (int i = 1; i <= 100; i++) {
                    sum += i;
                }

                return Integer.valueOf(sum);
            }
        }
}
/*
* interface Runnable{
* public void static run();
* }
* runnable中声明了一个不带返回值的run()，因为没有任何返回值，导致很多时候想使用线程执行的结果也无法使用。
*为了弥补Runnable 没有返回值得缺陷。在jdk1.5之后又提供了 callable，它是位于ava.util.concurrent包下，它也是一个接口，在它里面也只声明了一个方法，只不过这个方法叫做call()
*public interface Callable<V> { V call() }
*可以看到，这是一个泛型接口，call()函数返回的类型就是传递进来的V类型。
*因为Future只是一个接口，所以是无法直接用来创建对象使用的，因此就有了下面的FutureTask。
*  FutureTask<V> implements RunnableFuture<V>
*  interface RunnableFuture<V> extends Runnable, Future<V>
*    可以看出RunnableFuture继承了Runnable接口和Future接口，而FutureTask实现了RunnableFuture接口。所以它既可以作为Runnable被线程执行，又可以作为Future得到Callable的返回值。
* */