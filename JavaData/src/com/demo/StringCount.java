package com.demo;

/**
 * Creat|ed by xhp on 2016/10/24.
 * 判断一个字串在整串中出现的次数
 */
public class StringCount {
    public static void main(String[] args) {

        getCount("asfaeheehehsgnwuidehheehhehhegjiheeowdjgbinwhee","he");
    }
    public static int getCount(String src ,String tag){
        int index = 0;
        int count = 0;
        //indexof()返回指定字符在此字符串中第一次出现处的索引
        while ((index = src.indexOf(tag)) != -1){

            src = src.substring( index + tag.length() );   // index 4 + 4 = 8
            System.out.println( src.length() + " : " + index + " :  " + tag.length() );

            count++;
        }
        return count;
    }

}
