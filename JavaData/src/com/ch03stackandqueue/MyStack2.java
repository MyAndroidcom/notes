package com.ch03stackandqueue;

/**
 * Created by xhp on 2016/10/18.
 */
public class MyStack2 {

    //栈底层是一个数组
    private long[] arr;
    //栈顶位置
    private int top ;

    public MyStack2(){
        arr = new long[10];
        top = -1;
    }
    public MyStack2(int maxSize){
        arr = new long[maxSize];
        top = -1;
    }

    //添加数据
    public void push(long value){
        arr[++top] = value;
    }
    //移除数据
    public long pop(){
        return arr[top--];
    }
    //查看数据
    public long peek(){
        return arr[top];
    }
    //判断是否满了
    public boolean isFull(){
        return top == arr.length - 1;
    }
}
