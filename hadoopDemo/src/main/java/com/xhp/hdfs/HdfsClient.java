package com.xhp.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.Before;

import java.io.IOException;
import java.net.URI;
import org.junit.Test;

/**
 * Created by xhp on 2016/10/14.
 */
public class HdfsClient {

    FileSystem fs = null;
    @Before
    public void getFs() throws IOException {
        String url = "hdfs://hadoop:9000/";
        Configuration conf = new Configuration();
        fs = FileSystem.get(URI.create(url), conf);
    }

    @Test
    public void testMkdir() throws IOException {
        fs.mkdirs(new Path("/aa/cc"));
    }

    @Test
    public void testUpload() throws IOException {
        fs.copyFromLocalFile(new Path("/root"),new Path("/aa/cc"));
    }

}
