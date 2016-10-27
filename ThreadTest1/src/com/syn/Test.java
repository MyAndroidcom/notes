package com.syn;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;


//不能改动此Test类	
public class Test extends Thread{
	
	private TestDo testDo;
	private String key;
	private String value;
	
	public Test(String key,String key2,String value){
		this.testDo = TestDo.getInstance();
		/*常量"1"和"1"是同一个对象，下面这行代码就是要用"1"+""的方式产生新的对象，
		以实现内容没有改变，仍然相等（都还为"1"），但对象却不再是同一个的效果*/
		this.key = key+key2; //保证key不是同一个对象，不能使用synchronized同步方法实现
/*		a = "1"+"";
		b = "1"+""
*/
		this.value = value;
	}


	public static void main(String[] args) throws InterruptedException{
		Test a = new Test("1","","1");  //当key相同时互斥打印输出结果，
		Test b = new Test("1","","2");
		Test c = new Test("3","","3");
		Test d = new Test("4","","4");
		System.out.println("begin:"+(System.currentTimeMillis()/1000));
		a.start();
		b.start();
		c.start();
		d.start();

	}
	
	public void run(){
		testDo.doSome(key, value);
	}
}

class TestDo {

	private TestDo() {}
	private static TestDo _instance = new TestDo();	
	public static TestDo getInstance() {
		return _instance;
	}

	//private ArrayList keys = new ArrayList();
	//使用ArrayList在迭代时不能添加数据
	private CopyOnWriteArrayList keys = new CopyOnWriteArrayList();

	//当key相同时在下一秒打印,如果几个线程调用doSome()时，传递进去的key相等(eqluals()比较返回true)，
	//则这几个线程应互斥排队输出，当两个线程key都是"1"时，他们中的一个要比另外其他的线程晚一秒打印
	public void doSome(Object key, String value) {
		Object o = key;
		//keys含有o,keys里面有和key相等的
		if(!keys.contains(o)){
			keys.add(o);
		}else{

			for(Iterator iter=keys.iterator();iter.hasNext();){
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Object oo = iter.next();
				if(oo.equals(o)){
					o = oo;
					break;
				}
			}
		}
		synchronized(o)
		// 大括号内的是需要局部同步的代码，不能改动!
		{
			try {
				Thread.sleep(1000);
				System.out.println(key+":"+value + ":"
						+ (System.currentTimeMillis() / 1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

