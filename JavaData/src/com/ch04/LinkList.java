package com.ch04;

/**
 * 链表，相当于火车
 */
public class LinkList {
    //头结点
    private Node first;

    public LinkList() {
        first = null;
    }

    /*
    * 插入一个节点
    * */
    public void insertFirst(long value) {
        //new 一个新节点
        Node node = new Node(value);
        //这个节点的指针域指向头结点
        node.next = first;
        first = node;
    }
    //删除一个节点
    public Node deleteFirst(){
    //先把头结点放在tmp中
        Node tmp = first;
        //让tmp的下一个节点指向头结点
        first = tmp.next;
        return tmp;
    }
    //显示方法
    public void display(){
        Node current = first;
        while (current != null){
            current.display();
            current = current.next;
        }
        System.out.println();
    }
    /*
    * 查找方法
    * */
    public Node find(long value){
        Node current = first;
        while (current.data != value){
            if(current.next == null){
                return null;
            }
            current = current.next;
        }
        return current;
    }
    /**
     * 删除方法，根据数据域来进行删除
     */
    public Node delete(long value) {
        Node current = first;
        Node previous = first;
        while(current.data != value) {
            if(current.next == null) {
                return null;
            }
            previous = current;
            current = current.next;
        }

        if(current == first) {
            first = first.next;
        } else {
            previous.next = current.next;
        }
        return current;

    }
}
