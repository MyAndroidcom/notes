package com.file;

import java.io.File;

/**
 * Created by xhp on 2016/10/24.
 * 列出指定目录中所包含的子文件与子目录
 */
public class FileList {
    public static void main(String[] args) {
        listAllFilesAndDirs("c:/");
    }
    public static void listAllFilesAndDirs(String path){
        File dir = new File(path);
//        String[] list = dir.list();
        File[] files = dir.listFiles();
        for (File file:files) {
            if (file.isFile()) {
                System.out.println(("子文件："));
                System.out.println("\t" + file.getName());
            } else if (file.isDirectory()) {
                System.out.println(("子目录："));
                System.out.println("\t" + file.getName());
            }

        }
    }
}
