package com.xhp.hdfs;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;
import java.net.URI;

/*
* hdfs的测试文件
* */
public class Test {

    public static void main(String[] args) throws IOException {
        String url = "hdfs://hadoop:9000/";
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(URI.create(url), conf);

        Path path = new Path("hdfs://hadoop:9000/jdk");
        fs.create(path);//创建一个目录

        //列出hdfs上/  根目录下的所有文件和目录
        FileStatus[] statuses = fs.listStatus(new Path("/"));
        for (FileStatus status : statuses) {
            System.out.println(status);
        }

    }
}
