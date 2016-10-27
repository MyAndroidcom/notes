package com.thread.interview;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
public class CollectionModifyExceptionTest {
	public static void main(String[] args) {
		Collection users = new CopyOnWriteArrayList();
			
			//new ArrayList();
		User user1 = new User("张三", 28);
		users.add(user1);
		users.add(new User("李四",25));			
		users.add(new User("王五",31));	
		Iterator itrUsers = users.iterator();
		while(itrUsers.hasNext()){
			System.out.println("aaaa");
			User user = (User)itrUsers.next();
			if("王五".equals(user.getName())){
//				users.remove(user1);
				itrUsers.remove();
			} else {
				System.out.println(user);				
			}
		}
		System.out.println(users);
	}
}
