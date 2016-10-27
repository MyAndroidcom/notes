package com.ch09hash;

import java.math.BigInteger;

/**
 * Created by xhp on 2016/10/21.
 * 自定义HashTable底层是一个数组
 */
public class HashTable {
    private Info[] arr;

    public HashTable() {
        arr = new Info[100];
    }
    public HashTable(int maxSize){
        arr = new Info[maxSize];
    }
    //添加数据
    public void insert(Info info){
        arr[hashCode(info.getKey())] = info;
    }

    //查找数据
    public Info find(String key){
        return arr[hashCode(key)];
    }

    private int hashCode(String key) {
        BigInteger hashVal = new BigInteger("0");
        BigInteger pow27 = new BigInteger("1");
        for (int i = key.length()-1; i >= 0 ; i--) {
            int letter = key.charAt(i) - 96;//求a的ASC码a=97

            BigInteger letterB = new BigInteger(String.valueOf(letter));
            hashVal = hashVal.add(letterB.multiply(pow27));
            pow27 = pow27.multiply(new BigInteger(String.valueOf(27)));
        }
        return hashVal.mod(new BigInteger(String.valueOf(arr.length))).intValue();
    }
}
