package com.ch03stackandqueue;

import java.util.Arrays;

/**
 * Created by xhp on 2016/10/18.
 * 循环队列
 */
public class MyCycleQueue {
    private long[] arr;
    private int elements; //元素个数
    private int front;  //对头
    private int end;  //对尾

    public MyCycleQueue(){
        arr = new long[10];
        end = -1;
    }
    public MyCycleQueue(int maxSize){
        arr = new long[maxSize];
        end = -1;
    }
     public void insert(long value){
         //如果是删除完了后再插入
         if(end == arr.length - 1){
            end = -1;
         }
         arr[++end] = value;
         elements++;
     }
     //从对头处删除
     public long remove(){
         //判断如果只有最后一个元素，则把对头变为0
         if(++front == arr.length){
             front = 0;
         }
         elements--;
         return arr[front++];//删除后对头默认加1
     }
     // 查看从对头开始
    public long peek(){
        return arr[front];
    }
    //是否为空
    public boolean isEmpty(){
        return elements == 0;
    }
    // 是否满了
    public boolean isFull(){
        return elements == arr.length-1;
    }

    @Override
    public String toString() {
        return "MyCycleQueue{" +
                "arr=" + Arrays.toString(arr) +
                '}';
    }
}
