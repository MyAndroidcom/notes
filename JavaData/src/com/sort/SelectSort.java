package com.sort;

import java.util.Arrays;

/**
 * Created by xhp on 2016/10/23.
 */
public class SelectSort {
    public static void selectSort(long[] data){
        int length = data.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i+1; j < length; j++) {
                if(data[i] > data[j]){
                    long tmp = data[i];
                    data[i] = data[j];
                    data[j] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        long[] arr = {1,345,56,78,5,0,100,23};
        selectSort2(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void selectSort2(long[] data){
        int length = data.length;
        for (int i = 0; i < length - 1; i++) {
            int minIndex = i;
            for (int j = i+1; j < length; j++) {
                if(data[minIndex] > data[j]){
                    minIndex = j;
                }
            }
            if(minIndex != i){
                long tmp = data[i];
                data[i] = data[minIndex];
                data[minIndex] = tmp;
            }
        }
    }

}
