package com.test;

import java.util.PriorityQueue;

/**
 * Created by xhp on 2016/10/26.
 * 生产者--消费者模式,基于阻塞队列实现
 */
public class ProduceAndConsumer {

    private int queueSize = 10;
    private PriorityQueue<Integer> queue = new PriorityQueue<Integer>(queueSize);

    public static void main(String[] args) {
        ProduceAndConsumer produceAndConsumer = new ProduceAndConsumer();
        produceAndConsumer.new Consumer().start();
        produceAndConsumer.new Producer().start();
    }

    class Consumer extends Thread{
        @Override
        public void run() {

            consume();
        }
        private void consume() {
            while (true){
                synchronized (queue){
                    while (queue.size() == 0){
                        System.out.println("队列为空，等待数据...");
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            queue.notify();
                        }
                    }
                    queue.poll(); //每次移走队首元素
                    queue.notify();
                    System.out.println("从队列中取走一个元素，剩余"+queue.size()+"个元素");
                }
            }
        }
    }


    //生产者
    class Producer extends Thread{
        @Override
        public void run() {

            produce();
        }

        private void produce() {
            while (true) {
                synchronized (queue){
                    while (queue.size() == queueSize){
                        System.out.println("队列满，等待...");
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            queue.notify();
                        }
                    }
                    queue.offer(1);//每次插入一个元素
                    queue.notify();
                    System.out.println("向队列中插入一个元素，队列剩余:"+(queueSize-queue.size()));
                }
            }
        }
    }
}
