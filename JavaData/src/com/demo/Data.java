package com.demo;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * Created by xhp on 2016/10/24.
 */
public class Data {
    public static void main(String[] args) {
        Calendar sm = Calendar.getInstance();
        int year = sm.get(Calendar.YEAR);
        System.out.println(year);

        SimpleDateFormat ss = new SimpleDateFormat("yyyy年MM月dd日 E a hh时mm分ss秒");
        System.out.println(ss.format(new Date()));

        Random ran = new Random();
        char[] chars = {'1', 's', 'd', 'f', 'r', 'g', '7'};
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            stringBuilder.append(chars[ran.nextInt(chars.length)]);
        }
        System.out.println("校验码是:"+stringBuilder.toString());
    }
}
