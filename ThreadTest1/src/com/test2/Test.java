package com.test2;

import java.util.concurrent.Semaphore;
import java.util.concurrent.SynchronousQueue;


/*
* Test类中代码不断的产生数据，然后交给TestDao.doSome()去处理数据，好像生产者不断生产数据，消费者不断消费数据
* 将程序改造成10个消费者来消费生产者生产的数据都调用doSome()去处理，保证上一个消费者消费完后
* 下一个消费者才能消费数据
* */

public class Test {

	public static void main(String[] args) {
		final Semaphore semaphore = new Semaphore(1);

		//同步队列
		final SynchronousQueue<String> queue = new SynchronousQueue<String>();
		for(int i=0;i<10;i++){
			new Thread(new Runnable(){
				@Override
				public void run() {	
					try {
						//控制同时访问资源的线程个数
						semaphore.acquire();
						//从队列中取数据
						String input = queue.take();
						String output = TestDo.doSome(input);
						System.out.println(Thread.currentThread().getName()+ ":" + output);
						semaphore.release();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
				}
			}).start();
		}
		
		System.out.println("begin:"+(System.currentTimeMillis()/1000));
		for(int i=0;i<10;i++){  //这行不能改动
			String input = i+"";  //这行不能改动
			try {
				//使用队列，在队列中放入数据
				queue.put(input);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

//不能改动此TestDo类
class TestDo {
	public static String doSome(String input){
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String output = input + ":"+ (System.currentTimeMillis() / 1000);
		return output;
	}
}
