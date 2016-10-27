package com.xhp.thread;

/**
 * Created by xhp on 2016/10/7.
 */
public class TraditionalThread02 {

     static int num = 50;
    public static void main(String[] ar){
        new TraditionalThread02().init();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(i+"哈哈哈哈");
                }
            }
        }){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(i+"哇哇哇哇哇哇哇");
                }
            }
        }.start();

    }

    protected void init(){
//        Demo1 d1 = new Demo1();
//        d1.start();
        Demo2 d2 = new Demo2();
        d2.t1.start();
        Demo3 d3 = new Demo3();
        d3.t2.start();
        Demo4 d4 = new Demo4();
        Thread d = new Thread(d4,"狗娃");
        d.start();
        Demo5 d5 = new Demo5();
        d5.t5.start();
    }

    //传统方式一：继承Thread类
    class Demo1 extends Thread{
        @Override
        public void run() {
            for (int i=0;i<100;i++){
                System.out.println("传统方式,继承Thread一:"+Thread.currentThread().getName()+":"+i);
            }
        }
    }
    class Demo2{
        Thread t1 = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("传统方式，继承Thread二:"+Thread.currentThread().getName()+":"+i);
                }
            }
        };
    }
    class Demo3{
        Thread t2 = new Thread(){
            @Override
            public void run() {
                while (true){
                if(num>0){
                    System.out.println(Thread.currentThread().getName()+"售出了第"+num+"号票");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    num--;
                }else {
                    System.out.println("售罄了...");
                    break;
                }
                }
            }
        };
    }
        //方式二:实现Runnable接口
    class Demo4 implements Runnable{
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("传统方式二:实现Runnable接口(一):"+Thread.currentThread().getName());
                }
            }
        }

    class Demo5 {
       Thread t5 =new Thread(new Runnable(){

           @Override
           public void run() {
               for (int i = 0; i < 100; i++) {
                   System.out.println("传统方式二:Runnable接口(二):"+Thread.currentThread().getName());
                   try {
                       Thread.sleep(100);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
           }
       });
    }
}
