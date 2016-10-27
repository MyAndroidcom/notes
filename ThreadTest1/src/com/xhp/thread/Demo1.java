package com.xhp.thread;


class BankThread extends Thread{
	
	static	int count = 5000;
	
	public BankThread(String name){
		super(name);
	}
	
	@Override  //
	public synchronized  void run() {
		while(true){
			synchronized (" ") {
				if(count>0){
					System.out.println(Thread.currentThread().getName()+"取走了1000块,还剩余"+(count-1000)+"元");
					count= count - 1000;
				}else{
					System.out.println("抢光了...");
					break;
				}
			}
		}
	}	
	
	

}


public class Demo1 {

	public static void main(String[] args) {
		BankThread thread1 = new BankThread("老公");
		BankThread thread2 = new BankThread("老婆");
		thread1.start();
		thread2.start();

	}
	
}
