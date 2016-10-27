package com.xhp.thread;

/**
 * 多线程共享数据问题，定义两个线程，一个实现j++,一个j--,两个线程交替执行
 */
public class ThreadShareData {

    private static int j=0;//注意j是共享变量要声明为static
    private static boolean isFlag = true;//共享数据
    public static void main(String[] srr) {
        ThreadShareData t1 = new ThreadShareData();
        new Thread(t1.new Increment(),"++线程").start();
        new Thread(t1.new Decrement(),"--线程").start();
    }

    class Increment implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {

                inc();
            }
        }
    }

    class Decrement implements Runnable{

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                dec();
            }
        }
    }

    private void dec() {
        synchronized (Increment.class){
            while (isFlag){
                try {
                    Increment.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            j--;
            isFlag=true;
            Increment.class.notify();
            System.out.println(Thread.currentThread().getName()+":执行了--操作: "+j);
        }
    }

    private void inc() {
        synchronized (Increment.class){
            while (!isFlag){
                try {
                    Increment.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            j++;
            isFlag=false;
            Increment.class.notify();
            System.out.println(Thread.currentThread().getName()+":执行的++操作:"+j);
        }
    }

}
