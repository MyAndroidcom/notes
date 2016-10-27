package com.ch05;

/**
 * Created by xhp on 2016/10/18.
 */
public class Node {

    public long data;
    public Node next;
    public Node previous;

    public Node(long value){
        this.data = value;
    }
    //显示方法
    public void display(){
        System.out.println(data+" ");
    }
}
