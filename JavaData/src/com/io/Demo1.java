package com.io;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by xhp on 2016/10/24.
 * <p>
 * 需求：把a.txt与b.txt 文件的内容合并。
 */
public class Demo1 {
    public static void main(String[] args) throws IOException {
        merge1();
    }

    public static void merge2() throws IOException {
        File file1 = new File("D:/aa/a.txt");
        File file2 = new File("D:/aa/b.txt");
        File file3 = new File("D:/aa/c.txt");

        //建立数据的输入输出通道
        FileOutputStream outputStream = new FileOutputStream(file3);
        FileInputStream fileInputStream1 = new FileInputStream(file1);
        FileInputStream fileInputStream2 = new FileInputStream(file2);
        //建立序列流对象
        SequenceInputStream sequenceInputStream = new SequenceInputStream(fileInputStream1, fileInputStream2);
        byte[] buf = new byte[1024];
        int length = 0;
        while ((length = sequenceInputStream.read(buf)) != -1){
            outputStream.write(buf,0,length);
        }
        sequenceInputStream.close();
        outputStream.close();
    }

    public static void merge1() throws IOException {
        File file1 = new File("D:/aa/a.txt");
        File file2 = new File("D:/aa/b.txt");
        File file3 = new File("D:/aa/c.txt");
        //建立数据的输入输出通道
        FileOutputStream outputStream = new FileOutputStream(file3);
        FileInputStream fileInputStream1 = new FileInputStream(file1);
        FileInputStream fileInputStream2 = new FileInputStream(file2);

        ArrayList<FileInputStream> list = new ArrayList<>();
        list.add(fileInputStream1);
        list.add(fileInputStream2);

        //准备一个缓冲数组
        byte[] buf = new byte[1024];
        int length = 0;
        for (int i = 0; i < list.size(); i++) {
            FileInputStream fileInputStream = list.get(i);
            while ((length = fileInputStream.read(buf)) != -1){
                outputStream.write(buf,0,length);
            }
            fileInputStream.close();
        }
        outputStream.close();
    }
}
