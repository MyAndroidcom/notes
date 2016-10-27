package com.demo;

import java.util.Arrays;

/**
 * Created by xhp on 2016/10/23.
 */
public class ArrayList<T> {
    private final int DEFAULT_SIZE = 16;
    //数组长度
    private int capacity;
    private Object[] elementData;
    private int size = 0;

    public ArrayList() {
        capacity = DEFAULT_SIZE;
        elementData = new Object[capacity];
    }

    public ArrayList(T element) {
        this();
        elementData[0] = element;
        size++;
    }

    public ArrayList(T element, int initSize) {
        capacity = 1;
        //左移一位相当于*2^1,把capacity设为大于initSize的最小的2的n次方
        while (capacity < initSize){
            capacity <<= 1;
        }
        elementData = new Object[capacity];
        elementData[0] = element;
        size++;
    }

    //获取顺序线性表的大小
    public int length(){
        return size;
    }
    public T get(int i){
        if(i < 0 || i > size - 1){
            throw new IllegalArgumentException();
        }
        return (T) elementData[i];
    }
    public int locate(T element){
        for (int i = 0; i < size; i++) {
            if(elementData[i].equals(element)){
                return i;
            }
        }
        return -1;
    }
    public void insert(T element,int index){
        if(index < 0 || index > size){
            throw new IllegalArgumentException();
        }
        ensureCapacity(size + 1);
        //将指定索引之后的元素向后移动一格
        System.arraycopy(elementData,index,elementData,index+1,size-index);
        elementData[index]=element;
        size++;
    }
    //在开始处添加一格元素
    public void add(T element){
        insert(element,size);
    }

    private void ensureCapacity(int minCapacity) {
        if(minCapacity > capacity){
            while (capacity < minCapacity){
                capacity <<= 1;
            }
            elementData = Arrays.copyOf(elementData,capacity);
        }
    }

    //删除顺序线性表中指定索引处的元素
    public T delete(int index){
        if(index < 0 || index > size -1){
            throw new IllegalArgumentException();
        }
        T oldValue = (T) elementData[index];
        int numMoved = size - index - 1;
        if(numMoved > 0){
            System.arraycopy(elementData,index + 1,elementData,index,numMoved);
        }
        elementData[--size] = null;
        return oldValue;
    }
    //删除顺序线性表中最后一个元素
    public T remove(){
        return delete(--size);
    }
    //判断顺序线性表是否为空
    public boolean empty(){
        return size == 0;
    }
    //清空线性表
    public void clear(){
        Arrays.fill(elementData,null);
        size = 0;
    }
    public String toString(){
        if(size == 0){
            return "[]";
        }
        else {
            StringBuilder sb = new StringBuilder("[");
            for (int i = 0; i < size; i++) {
                sb.append(elementData[i].toString()+", ");
            }
            int length = sb.length();
            return sb.delete(length -2,length).append("]").toString();
        }
    }

    public static void main(String[] args) {
        ArrayList<String> stringArrayList = new ArrayList<>();
        stringArrayList.add("asddfasd");
        stringArrayList.add("sbsbsbsbs");
        stringArrayList.add("1213");
        stringArrayList.insert("撒尿",0);

        System.out.println(stringArrayList);

    }
}
