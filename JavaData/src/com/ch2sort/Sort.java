package com.ch2sort;

/**
 * Created by xhp on 2016/10/18.
 */
public class Sort {
    long tmp = 0;

    //冒泡
    public void BubbleSort(long[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] > arr[j - 1]) {
                    tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                }
            }
        }
    }

    //冒泡第二种写法
    public void BubbleSort2(long[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    //直接排序,时间复杂度最大
    public void sort(long[] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }
    //直接选择排序
    public void SelectSort(long[] arr){
        int k = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            k = i;  //k指向当前遍历的一块数据
            for (int j = i; j < arr.length; j++) {
                if(arr[j] < arr[k]){
                    k = j;  //k中每次存放最小的元素
                }
            }
            tmp = arr[i];
            arr[i] = arr[k];
            arr[k] = tmp;
        }
    }
    //插入排序,此方法只适用于数组元素有序的情况
    public void InsertSort(long[] arr){
        for (int i = 1; i < arr.length; i++) {
            tmp = arr[i];
            int j = i;
            while (j > 0 && arr[j] >= tmp){
                //右移
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = tmp;
        }
    }
}
