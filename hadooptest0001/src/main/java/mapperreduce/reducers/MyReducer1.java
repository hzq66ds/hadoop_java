package mapperreduce.reducers;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * Created by hanzhiqiang on 2019/3/10.
 */
public class MyReducer1 extends Reducer<IntWritable,Text,IntWritable,Text> {
    @Override
    protected void reduce(IntWritable key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        String num = "";
        for (Text nums:values) {
            num += nums.toString();
        }
        context.write(key,new Text(num));
    }
}
