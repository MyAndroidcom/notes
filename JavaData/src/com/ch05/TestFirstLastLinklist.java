package com.ch05;

/**
 * Created by xhp on 2016/10/18.
 */
public class TestFirstLastLinklist {
    public static void main(String[] args) {
        FirstLastLinklist firstLastLinklist = new FirstLastLinklist();

        firstLastLinklist.insertFirst(12314);
        firstLastLinklist.insertLast(10000);
        firstLastLinklist.insertLast(1000);
        firstLastLinklist.insertLast(100);
        firstLastLinklist.insertLast(10);
        firstLastLinklist.insertLast(1);
        firstLastLinklist.deleteFirst();

        firstLastLinklist.delete(1);

        firstLastLinklist.display();
    }
}
