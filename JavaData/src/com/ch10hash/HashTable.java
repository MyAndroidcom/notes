package com.ch10hash;

import java.math.BigInteger;

/**
 * Created by xhp on 2016/10/21.
 * 解决hash值冲突的问题
 */
public class HashTable {
    private Info[] arr;

    public HashTable(){
        arr = new Info[100];
    }
    public HashTable(int maxSize){
        arr = new Info[maxSize];
    }
    /*
    * 插入数据
    * */
    public void insert(Info info){
        String key = info.getKey();
        //关键字所自定义的hash值
        int hashVal = hashCode(key);
        //hash值冲突即改索引已经被占用
        while (arr[hashVal] != null && arr[hashVal].getName()!= null){
            ++hashVal;
            hashVal %= arr.length;
        }
        arr[hashVal] = info;
    }

    /*
    * 查找数据
    * */
    public Info find(String key){
        int hashVal = hashCode(key);
        while (arr[hashVal] != null){
            if(arr[hashVal].getKey().equals(key)){
                return arr[hashVal];
            }
            ++hashVal;
            hashVal %= arr.length;
        }
        return null;
    }
    /*
    * 删除数据
    * */
    public Info delete(String key){
        int hashVal = hashCode(key);
        while (arr[hashVal] != null){
            if(arr[hashVal].getKey().equals(key)){
                Info tmp = arr[hashVal];
                tmp.setName(null);
                return tmp;
            }
        }
        return null;
    }
    private int hashCode(String key) {
        BigInteger hashVal = new BigInteger("0");
        BigInteger pow27 = new BigInteger("1");
        for (int i = key.length()-1; i >= 0 ; i--) {
            int letter = key.charAt(i) - 96;
            BigInteger letterB = new BigInteger(String.valueOf(letter));
            hashVal = hashVal.add(letterB.multiply(pow27));
            pow27 = pow27.multiply(new BigInteger(String.valueOf(27)));
        }
        return hashVal.mod(new BigInteger(String.valueOf(arr.length))).intValue();
    }

}
