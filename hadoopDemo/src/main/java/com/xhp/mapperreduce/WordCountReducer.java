package com.xhp.mapperreduce;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * Created by xhp on 2016/10/15.
 */
public class WordCountReducer extends Reducer<Text,LongWritable,Text,LongWritable>{

    //传入mapper的key:hello ， value:{1,1,1...}
    @Override
    protected void reduce(Text key, Iterable<LongWritable> values, Context context) throws IOException, InterruptedException {

        /*
        * reduce函数的输入也是一个key/value的形式，不过它的value是一个迭代器的形式Iterable<IntWritable> values，
        * 也就是说reduce的输入是一个key对应一组的值的value，reduce也有context和map的context作用一致。
        * */

        //定义一个累加计数器
        long count = 0;
        for (LongWritable value:values
             ) {
            count += value.get();
        }
        //输出 <hello,count>键值对
        context.write(key,new LongWritable(count));
    }
}
