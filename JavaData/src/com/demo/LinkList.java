package com.demo;


/**
 * Created by xhp on 2016/10/23.
 */
public class LinkList<T> {
    private class Node {
        //保存节点的数据
        private T data;

        private Node next;

        public Node()
        {

        }

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
    //保存该链表的头结点
    private Node header;
    //尾节点
    private Node tail;

    private int size;

    public LinkList(){
        header = null;
        tail = null;
    }
    public LinkList(T element){
        header = new Node(element,null);
        //只有一个头结点
        tail = header;
        size++;
    }
    public int length(){
        return size;
    }
    public T get(int index){
        return getNodeByIndex(index);
    }

    private T getNodeByIndex(int index) {
        if(index < 0 || index > size -1){
            throw new IllegalArgumentException();
        }
        Node current = header;
        for (int i = 0; i < size && current != null; i++,current = current.next) {
            if(i == index){
                return (T) current;
            }
        }
        return null;
    }
    public int locate(T element){
        Node current = header;
        for (int i = 0; i < size && current != null; i++,current= current.next) {
            if(current.data.equals(element)){
                return i;
            }
        }
        return  -1;
    }

}
