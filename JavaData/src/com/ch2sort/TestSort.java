package com.ch2sort;

import java.util.Arrays;

/**
 * Created by xhp on 2016/10/18.
 */
public class TestSort {
    public static void main(String[] args) {
        long[] arr = {12,3,456,2,0,9,777,78};
        Sort sort = new Sort();
        sort.BubbleSort2(arr);
        System.out.println(Arrays.toString(arr));
//        InsertSort.sort(arr);
//        System.out.println(Arrays.toString(arr));
    }
}
