package com.thread.interview;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

//阻塞队列,实现数据交互

public class BlockingQueueCommunication {

    public static void main(String[] args) {

        final Business business = new Business();
        new Thread(
                new Runnable() {

                    @Override
                    public void run() {

                        for (int i = 1; i <= 50; i++) {
                            business.sub(i);
                        }

                    }
                }
        ).start();

        for (int i = 1; i <= 50; i++) {
            business.main(i);
        }

    }

    static class Business {


        BlockingQueue<Integer> queue1 = new ArrayBlockingQueue<Integer>(1);
        BlockingQueue<Integer> queue2 = new ArrayBlockingQueue<Integer>(1);


        //匿名构造方法，运行在任何构造方法之前,创建几个对象,就会调用几次
        {
//            Collections.synchronizedMap(null);
            try {
                System.out.println("xxxxxdfsdsafdsa");
                queue2.put(1);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        public void sub(int i) {
            try {
                queue1.put(1);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            for (int j = 1; j <= 10; j++) {
                System.out.println("sub thread sequece of " + j + ",loop of " + i);
            }
            try {
                queue2.take();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        public void main(int i) {
            try {
                queue2.put(1);
            } catch (InterruptedException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            for (int j = 1; j <= 100; j++) {
                System.out.println("main thread sequece of " + j + ",loop of " + i);
            }
            try {
                queue1.take();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
