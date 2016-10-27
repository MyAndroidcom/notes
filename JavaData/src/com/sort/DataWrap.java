package com.sort;

/**
 * Created by xhp on 2016/10/23.
 */
public class DataWrap implements Comparable<DataWrap> {
    int data;
    String flag;

    public DataWrap(int data, String flag) {
        this.data = data;
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "DataWrap{" +
                "data=" + data +
                ", flag='" + flag + '\'' +
                '}';
    }

    @Override
    public int compareTo(DataWrap dw) {
        return this.data > dw.data ? 1 :(this.data == dw.data ? 0 : -1);
    }
}
