package com.ch08tree;

/**
 * Created by xhp on 2016/10/20.
 */
public class TestTree {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(123,"sss");
        tree.insert(000,"ddd");
        tree.insert(10,"ddd");
        tree.insert(90,"ddd");
        tree.insert(8000,"ddd");
        tree.insert(4,"iii");

//        System.out.println(tree.root.leftChild.rightChild.leftChild.data);

//        System.out.println(tree.find(4).sData);
//        tree.inOrder(tree.root);
//        tree.afterOrder(tree.root);
        tree.frontOrder(tree.root);
    }
}
