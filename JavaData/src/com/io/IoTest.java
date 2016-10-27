package com.io;

import com.file.FileList;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by xhp on 2016/10/24.
 *
 */
public class IoTest {
    public static void main(String[] args) throws Exception {
//            writeFileTest("D:/aa/a.txt");
//            readFileTest("D:/aa/a.txt");
            showContent("D:/aa/a.txt");
    }

    private static void readFileTest(String path) throws Exception {
        File file = new File(path);
//        System.out.println(file.length());
        FileInputStream fileInputStream = new FileInputStream(file);

        fileInputStream.close();
    }

    private static void writeFileTest(String path){
        File file = new File(path);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write('H');
            fileOutputStream.write('e');
            fileOutputStream.write('l');
            fileOutputStream.write('l');
            fileOutputStream.write('o');
            fileOutputStream.write('!');
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void showContent(String path) throws Exception {
        FileInputStream stream = new FileInputStream(path);
        int len ;
        while ((len = stream.read()) != -1){
            System.out.print((char)len);
        }
        stream.close();
    }
}
