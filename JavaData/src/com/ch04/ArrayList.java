package com.ch04;


import java.util.Collection;
import java.util.Iterator;

/**
 * Created by xhp on 2016/10/18.
 */
public class ArrayList<T> implements Iterable<T>, Iterator<T> {

    private Object[] arr;

    private int size;

    private int capicity;
    public ArrayList() {
        arr = new Object[10];
        capicity = 10;
    }

    public void add(T t) {

        if(size > arr.length - 1){
            Object[] newArr = new Object[arr.length * 2];
            System.arraycopy(arr,0,newArr,0,arr.length);
            arr = newArr;
        }
        arr[size] = t;
        size++;
    }

    public T remove(int index){
        if(index < 0  || index >= size){
            throw new IllegalArgumentException();
        }
        if (index == size - 1){
            arr[index]=null;
        }else {
            System.arraycopy(arr, index + 1, arr, index, size - index - 1);
        }
        size--;
        return (T) arr[index];
    }

    public boolean addAll(Collection<T> c){
        for (T t : c) {
            add(t);
        }
        return true;
    }

    public T set(int index,T element){
        arr[index] = element;
        return (T) arr[index];
    }
    private int current;

    @Override
    public Iterator<T> iterator() {
        return this;
    }

    @Override
    public boolean hasNext() {
        boolean hasNext = current<size;
        if(!hasNext){
            current=0;
        }
        return hasNext;
    }

    @Override
    public T next() {
        return (T) arr[current++];
    }

    @Override
    public void remove() {

    }
}
