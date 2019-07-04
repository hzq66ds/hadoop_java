package mapperreduce.reducers;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * Created by hanzhiqiang on 2019/3/10.
 */
public class MyReducer3 extends Reducer<Text,IntWritable,Text,IntWritable> {
    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        int num = 0;
        int count = 0;
        for (IntWritable nums:values) {
            num += nums.get();
            count++;
        }
        num = num/count;
        context.write(new Text("avg("+key.toString()+")"+count),new IntWritable(num));
    }
}
