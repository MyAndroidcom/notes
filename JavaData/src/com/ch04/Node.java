package com.ch04;

import java.util.*;

/**
 * 连接点，相当于车厢
 */
public class Node {
    //数据域
    public long data;
    //指针域
    public Node next;

    public Node(long value) {
        this.data = value;
    }

    public void display() {
        System.out.print(data + " ");
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}
