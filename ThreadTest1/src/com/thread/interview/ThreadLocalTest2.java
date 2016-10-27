package com.thread.interview;

import org.junit.Test;

import javax.swing.text.Segment;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by xhp on 2016/10/7.
 */
public class ThreadLocalTest2 {

    static ThreadLocal<String> map = new ThreadLocal<>();
    public static void main(String[] s){
        new Thread(new A()).start();
        new Thread(new B()).start();
    }
    static class A implements Runnable{

        @Override
        public void run() {
            map.set("111");
        }
    }
    static class B implements Runnable{

        @Override
        public void run() {
            System.out.println( map.get());
        }
    }
    @Test
    public void testHashMap(){
        Map<String,String> map = new HashMap<>();
        String s = map.put("123", "哈哈");

        String s1 = map.get("123");
        System.out.println(s1);

        Map<String,String> table = new Hashtable<>();
        String sbsbs = table.put("11", "sbsbs");

        ConcurrentHashMap<String,String> concurrentHashMap = new ConcurrentHashMap<>();

    }
}
