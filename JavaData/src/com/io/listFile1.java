package com.io;

import java.io.File;

/**
 * Created by xhp on 2016/10/24.
 */
public class listFile1 {
    public static void main(String[] args) {
        File dir = new File("c:/");
        listFiles3(dir,"|--");
    }


    public static void listFiles3(File dir, String space){ //space 存储的是空格
        File[] files = dir.listFiles(); //列出所有 的子文件
        for(File file : files){
            if(file.isFile()){
                System.out.println(space+file.getName());
            }else if(file.isDirectory()){
                System.out.println(space+file.getName());
                listFiles3(file,"|   "+space);
            }

        }
    }
}
