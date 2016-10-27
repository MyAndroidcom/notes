package com.ch07tree;

/**
 * Created by xhp on 2016/10/19.
 */
public class Node {
    //数据项
    public long data;
    //数据项
    public String sData;
    //左子节点
    public Node leftChild;
    //右子节点
    public Node rightChild;

    /*
    * 构造方法
    * */
    public Node(long data,String sData){
        this.data = data;
        this.sData = sData;
    }
}
