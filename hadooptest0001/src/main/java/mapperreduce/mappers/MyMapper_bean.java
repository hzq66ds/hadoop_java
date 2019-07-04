package mapperreduce.mappers;

import mapperreduce.mr_beans.Bean01;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * Created by hanzhiqiang on 2019/3/11.
 */
public class MyMapper_bean extends Mapper<LongWritable,Text,Bean01,Bean01>{
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] values = value.toString().split(",");
        Bean01 bean01 = new Bean01();
        bean01.setName(values[0]);
        bean01.setAge(Integer.parseInt(values[1]));
        bean01.setDepno(values[2]);
        context.write(bean01, bean01);
    }
}
