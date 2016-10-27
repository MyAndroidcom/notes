package com.ch07tree;

/**
 * Created by xhp on 2016/10/19.
 */
public class Tree {
    //根节点
    public Node root;
    /*
    * 插入节点
    * */
    public void insert(long value,String sValue){
        //封装节点
        Node newNode = new Node(value,sValue);
        //引用根节点为当前节点
        Node current = root;
        //引用父节点
        Node parent;
        //如果root为null，也就是第一次插入
        if(root == null){
            root = newNode;
            return;
        }else {
            while (true){
                //父节点指向当前节点
                parent = current;
                //如果当前节点指向的节点数据比插入的要大，则向左走,即要插入的数据小,向左走
                if(current.data > value){
                    current = current.leftChild;
                    if(current == null){
                        parent.leftChild = newNode;
                        return;
                    }
                }else {
                    current = current.rightChild;
                    if(current == null){
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }
    //查找节点
    public Node find(long value){
        //引用当前节点从根节点开始
        Node current = root;
        //循环，只要查找值不等于当前节点的数据项
        while (current.data != value){
            //进行比较,比较查找值与当前节点的大小
            if (current.data > value){
                current = current.leftChild;
            }else {
                current = current.rightChild;
            }
            //查找不到，返回null
            if(current ==null){
                return null;
            }
        }
        return current;
    }
    /*
    * 删除节点
    * */
    public void delete(long value){

    }

}
