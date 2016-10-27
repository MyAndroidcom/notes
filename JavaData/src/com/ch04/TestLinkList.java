package com.ch04;

/**
 * Created by xhp on 2016/10/18.
 */
public class TestLinkList {
    public static void main(String[] args) {
        LinkList linkList = new LinkList();
        linkList.insertFirst(34);
        linkList.insertFirst(23);
        linkList.insertFirst(12);
        linkList.insertFirst(0);
        linkList.insertFirst(-1);

        linkList.deleteFirst();
        linkList.display();
        linkList.delete(-1);
		linkList.display();
    }
}
