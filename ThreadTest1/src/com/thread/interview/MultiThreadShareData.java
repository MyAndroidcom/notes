package com.thread.interview;

/**
 * 多线程共享数据
 * 三种方式:
 * 1.每个线程的方法执行的代码相同，可以用一个Runnable对象实现共享
 * 2.将共享数据封装在另一个对象中
 * 3.将Runnable对象作为一个内部类，共享数据作为这个外部类的成员变量，每个线程对共享数据的操作分配到外部类
 */
public class MultiThreadShareData {

    public static void main(String[] arg){
        MultiThreadShareData m1 = new MultiThreadShareData();
        new Thread(m1.new ShareData1(),"哈哈哈哈").start();
        new Thread(m1.new ShareData1(),"啊啊啊啊").start();


    }
    class ShareData1 implements Runnable{
        //共享数据方式一
        private int count = 100;
        @Override
        public void run() {

            while (count!=0){
                count--;
                System.out.println(Thread.currentThread().getName()+"我来操作多线程: " +count);
            }
        }
    }
    //共享数据方法二
    class ShareData2 {
        private int j = 0;
        private synchronized void increment(){
            j++;
        }
        private synchronized void descrement(){
            j--;
        }
    }

    class MyRunnable implements Runnable{
        private ShareData2 shareDate2;

        public MyRunnable(ShareData2 shareDate2) {
            this.shareDate2 = shareDate2;
        }

        @Override
        public void run() {
            shareDate2.descrement();
        }
    }
}
