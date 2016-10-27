package com.ch03stackandqueue;

/**
 * 栈实现
 * 先进后出，后进先出
 */
public class MyStack {
    //底层是一个数组
    private long[] arr;
    private int top;
    /*
    * 默认构造方法
    * */
    public MyStack(){
        arr = new long[10];
        top = -1;
    }
    //带参数的构造方法
    public MyStack(int maxsize){
        arr = new long[maxsize];
        top = -1;
    }
    //添加数据
    public void push(int value){
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
    //  判断是否为空
    public boolean isEmpty(){
        return top == -1;
    }
    //判断是否满
    public boolean isFull(){
        return top == arr.length - 1;
    }
}
