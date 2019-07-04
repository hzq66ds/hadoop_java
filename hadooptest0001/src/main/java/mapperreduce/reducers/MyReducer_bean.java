package mapperreduce.reducers;

import mapperreduce.mr_beans.Bean01;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * Created by hanzhiqiang on 2019/3/10.
 */
public class MyReducer_bean extends Reducer<Bean01,Bean01,Bean01,NullWritable> {
    @Override
    protected void reduce(Bean01 key, Iterable<Bean01> values, Context context) throws IOException, InterruptedException {

        StringBuffer buffer = new StringBuffer();
        Bean01 bean01 = null;
        for (Bean01 b :values) {
            buffer.append(b.toString());
            bean01 = b;
        }
        context.write(bean01 ,NullWritable.get());
    }
}
