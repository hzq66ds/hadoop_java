package mapperreduce.partition;

import mapperreduce.mr_beans.Bean01;
import org.apache.hadoop.mapreduce.Partitioner;

/**
 * Created by hanzhiqiang on 2019/3/11.
 */
public class Bean01Partition extends Partitioner<Bean01,Bean01> {


    public int getPartition(Bean01 bean01, Bean01 bean012, int numPartition) {
        if (bean012.getAge()<=10){
            return 1%numPartition;
        }else if(bean012.getAge()<=20){
            return 2%numPartition;
        }else {
            return 3%numPartition;
        }
    }
}
