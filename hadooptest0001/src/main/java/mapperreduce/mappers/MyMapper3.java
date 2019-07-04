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
public class MyMapper3 extends Mapper<LongWritable,Text,Text,IntWritable> {
    @Override
    protected void map(LongWritable  key,Text value, Context context) throws IOException, InterruptedException {
        String[] values = value.toString().split(",");
        context.write(new Text("sla"+values[3]),new IntWritable(Integer.parseInt(values[5])));
    }
}
