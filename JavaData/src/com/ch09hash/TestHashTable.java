package com.ch09hash;

/**
 * Created by xhp on 2016/10/21.
 */
public class TestHashTable {
    public static void main(String[] args) {
        HashTable hh = new HashTable();
        hh.insert(new Info("aa","大智"));
        hh.insert(new Info("bb","王姐"));
        hh.insert(new Info("adad","傻逼"));

        System.out.println(hh.find("aa").getName());

    }


}
