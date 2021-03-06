package mapperreduce.mappers;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * Created by hanzhiqiang on 2019/3/10.
 * had
 */
public class MyMapper1 extends Mapper<LongWritable,Text,IntWritable,Text> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] values = value.toString().split(" ");
        for (String str:values) {
            context.write(new IntWritable(1),new Text(str));
        }
    }
}
