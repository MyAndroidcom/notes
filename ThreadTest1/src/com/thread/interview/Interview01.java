package com.thread.interview;

/**
 * 四个线程，两个对j++,两个对j--
 * 两个线程一个++，一个--轮询执行100次
 */
public class Interview01 {

    private static int j;

    private  boolean isFlag = true;

    public static void main(String[] ar) {

        Interview01 interview01 = new Interview01();

        Inc inc = interview01.new Inc();
        Des des = interview01.new Des();
        new Thread(inc, "++线程").start();
        new Thread(des, "--线程").start();
    }

    class Inc implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                inc();
            }
        }
    }

    class Des implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {

                des();
            }
        }
    }

    private void des() {
        synchronized (Interview01.class) {
            while (!isFlag) {
//                System.out.println("=====================--等待");
                try {
                    Interview01.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            j--;
            System.out.println(Thread.currentThread().getName() + ":--操作,j=" + j);
            isFlag = false;
            Interview01.class.notify();
        }
    }

    private void inc() {
        synchronized (Interview01.class) {
            while (isFlag) {
//                System.out.println("+++++++++++++++等待");
                try {
                    Interview01.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            j++;
            System.out.println(Thread.currentThread().getName() + ":++操作,j=" + j);
            isFlag = true;
            Interview01.class.notify();
        }
    }


}
