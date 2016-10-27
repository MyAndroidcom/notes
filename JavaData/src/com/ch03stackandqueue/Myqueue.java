package com.ch03stackandqueue;

/**
 * 队列
 */
public class Myqueue {
    private long[] arr;
    private int elements;   //有效数据的大小
    private int front;  //对头
    private int end;    //对尾

    public Myqueue(){
        arr = new long[10];
        elements = 0;
        front = 0;
        end = -1;
    }

    /*
    * 带参数的构造方法
    * */
    public Myqueue(int maxSize){
        arr = new long[maxSize];
        elements = 0;
        front = 0;
        end = -1;
    }
    /*
    * 添加数据，从对尾添加
    * */
    public void  insert(long value){
        arr[++end] = value;
        elements++;
    }
    /*
    * 删除数据,从对头删除
    * */
    public long remove(){
        elements--;
        //对头默认是0，删除一个后+1
        return arr[front++];
    }
    /*
    * 查看数据，从对头查看
    * */
    public long peek(){
        return arr[front];
    }
    //判断是否为空
    public boolean isEmpty(){
        return elements == 0;
    }
    //判断是否满了
    public boolean isFull(){
        return elements == arr.length;
    }
}
