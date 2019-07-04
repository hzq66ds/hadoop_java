package mapperreduce;

import mapperreduce.mappers.*;
import mapperreduce.mr_beans.Bean01;
import mapperreduce.partition.Bean01Partition;
import mapperreduce.reducers.*;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

/**
 * Created by hanzhiqiang on 2019/3/10.
 */
public class WordCountmain {
    public static void main(String[] agrs){
        try {
            Job job = Job.getInstance();
            //设定MR的入口
            job.setJarByClass(WordCountmain.class);

            if ("1".equals(agrs[0])) {
                //计算单词总数
                //设定job的Mapper和输出类型
                job.setMapperClass(MyMapper.class);
                job.setMapOutputKeyClass(Text.class);
                job.setMapOutputValueClass(IntWritable.class);

                //设定job的Reducer和输出类型
                job.setReducerClass(MyReducer.class);
                job.setOutputKeyClass(Text.class);
                job.setOutputValueClass(IntWritable.class);
            }else if("2".equals(agrs[0])){
                //将所有字符串去重，并进行拼接
                //设定job的Mapper和输出类型
                job.setMapperClass(MyMapper1.class);
                job.setMapOutputKeyClass(IntWritable.class);
                job.setMapOutputValueClass(Text.class);

                //设定job的Reducer和输出类型
                job.setReducerClass(MyReducer1.class);
                job.setOutputKeyClass(IntWritable.class);
                job.setOutputValueClass(Text.class);
            }else if("3".equals(agrs[0])){
                //计算总工资
                //设定job的Mapper和输出类型
                job.setMapperClass(MyMapper2.class);
                job.setMapOutputKeyClass(Text.class);
                job.setMapOutputValueClass(IntWritable.class);

                //设定job的Reducer和输出类型
                job.setReducerClass(MyReducer2.class);
                job.setOutputKeyClass(Text.class);
                job.setOutputValueClass(IntWritable.class);
            }else if("4".equals(agrs[0])){
                //计算各部门的总工资
                //设定job的Mapper和输出类型
                job.setMapperClass(MyMapper3.class);
                job.setMapOutputKeyClass(Text.class);
                job.setMapOutputValueClass(IntWritable.class);

                //设定job的Reducer和输出类型
                job.setReducerClass(MyReducer2.class);
                job.setOutputKeyClass(Text.class);
                job.setOutputValueClass(IntWritable.class);
            }else if("5".equals(agrs[0])){
                //计算各部门的平均工资
                //设定job的Mapper和输出类型
                job.setMapperClass(MyMapper3.class);
                job.setMapOutputKeyClass(Text.class);
                job.setMapOutputValueClass(IntWritable.class);

                //设定job的Reducer和输出类型
                job.setReducerClass(MyReducer3.class);
                job.setOutputKeyClass(Text.class);
                job.setOutputValueClass(IntWritable.class);
            }else if("bean".equals(agrs[0])){
                //计算各部门的平均工资
                //设定job的Mapper和输出类型
                job.setMapperClass(MyMapper_bean.class);
                job.setMapOutputKeyClass(Bean01.class);
                job.setMapOutputValueClass(Bean01.class);

                //设定job的Reducer和输出类型
                job.setReducerClass(MyReducer_bean.class);
                job.setOutputKeyClass(Bean01.class);
                job.setOutputValueClass(NullWritable.class);

//                job.setCombinerClass(MyCombanier.class);
                job.setPartitionerClass(Bean01Partition.class);
                job.setNumReduceTasks(3);
            }
            //设定整个任务的HDFS的输入和输出
            FileInputFormat.setInputPaths(job, new Path(agrs[1]));
//            FileInputFormat.setInputPaths(job,new Path("/user/root/input/test.txt"));
            FileOutputFormat.setOutputPath(job, new Path(agrs[2]+agrs[0]));
//            FileOutputFormat.setOutputPath(job,new Path("/user/root/output1"));

            //提交任务
            job.waitForCompletion(true);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
