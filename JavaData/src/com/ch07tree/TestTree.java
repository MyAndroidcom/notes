package com.ch07tree;

/**
 * Created by xhp on 2016/10/19.
 */
public class TestTree {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(111,"1243");
        tree.insert(100,"sbsb");
        tree.insert(200,"xxx");
        tree.insert(1,"iii");
        System.out.println(tree.root.data);
        System.out.println(tree.root.leftChild.sData);

        Node node = tree.find(200);
        System.out.println(node.data+","+node.sData);
    }
}
