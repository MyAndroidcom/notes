package com.xhp.mapperreduce;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.util.StringUtils;

import java.io.IOException;

/**
 * Created by xhp on 2016/10/15.
 */
public class WordCountMapper extends Mapper<LongWritable, Text, Text, LongWritable>{

    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        /*
        * 这里有三个参数，前面两个Object key, Text value就是输入的key和value，第三个参数Context context这是可以记录输入的key和value，
        * 例如：context.write(word, one);此外context还会记录map运算的状态
        * */

        //获取到一行文件的内容
        String line = value.toString();
        //切分
        String[] split = StringUtils.split(line, ' ');
        for (String word : split
                ) {
            context.write(new Text(word),new LongWritable(1));
        }
    }
}
