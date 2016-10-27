package com.ch2sort;

import java.util.Arrays;

/**
 *  希尔排序,非稳定排序算法。
 */
public class ShellSort {
    public static void sort(long[] arr){
        //初始化一个间隔
        int h = 1;
        //计算最大间隔
        while (h < arr.length/3){
            h = h * 3 + 1;
        }
        while (h > 0){
            //进行插入排序
            long tmp = 0;
            int j;
            for (int i = h; i < arr.length; i++) {
                tmp = arr[i];
                for ( j = i - h; j >= 0 && tmp < arr[j]; j-=h) {
                    arr[j + h] = arr[j];
                }
                arr[j + h] = tmp;
            }
            h = (h - 1)/3;
        }
    }

    public static void main(String[] args) {
        long[] aa = {100,13,4,6,87,9,3,67,89,9,2,34,21,1};
        sort(aa);
        System.out.println(Arrays.toString(aa));
    }
}
