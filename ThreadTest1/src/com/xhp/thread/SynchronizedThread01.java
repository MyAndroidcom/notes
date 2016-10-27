package com.xhp.thread;

/**
 * Created by xhp on 2016/10/7.
 */
public class SynchronizedThread01 {


    public static void main(String[] aa){
            new SynchronizedThread01().init();

    }
    private  void init(){
        final Outputer out = new Outputer();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    out.output("dazhi");
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    out.output("shaqiang");
                }
            }
        }).start();
    }

    static class Outputer{
        public void output(String output) {
            synchronized(this){
                for (int i = 0; i < output.length(); i++) {
                System.out.print(output.charAt(i));
            }
            System.out.println();
        }
        }
    }
}
