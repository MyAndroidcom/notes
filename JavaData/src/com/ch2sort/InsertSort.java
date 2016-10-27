package com.ch2sort;


import java.util.Arrays;

/**
 * Created by xhp on 2016/10/18.
 */
public class InsertSort {


    public static void sort(long[] arr) {
        for (int i = 1; i < arr.length; i++) {  //n-1趟扫描
            long tmp = arr[i]; //每次将arr[i]插入到前面排序序列中
            int j;
            for ( j = i-1;j>=0 && tmp < arr[j];j--) { //将前面较大的元素向后移动
                arr[j+1] = arr[j];
            }
            arr[j+1] = tmp; //tmp到达插入位置

        }
    }

    public static void main(String[] args) {
        long[] arr = {12,3,456,2,2};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
