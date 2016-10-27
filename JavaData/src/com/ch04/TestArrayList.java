package com.ch04;

/**
 * Created by xhp on 2016/10/18.
 */
public class TestArrayList {
    public static void main(String[] args) {
        ArrayList<Long> arrayList = new ArrayList<>();
        arrayList.add(12L);
        arrayList.add(23L);
        arrayList.add(13L);
        arrayList.add(124L);

//        arrayList.remove(3);
        java.util.ArrayList<Long> objects = new java.util.ArrayList<>();
        objects.add(123415326L);
        arrayList.addAll(objects);

        arrayList.set(0,10000L);
        for (Long aa : arrayList) {
            System.out.print(aa + " ");
        }
        System.out.println("======================================");
        for (Long aa : arrayList) {
            System.out.print(aa + " ");
        }
    }
}
