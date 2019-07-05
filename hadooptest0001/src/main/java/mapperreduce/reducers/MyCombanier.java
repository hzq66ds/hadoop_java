package mapperreduce.reducers;

import mapperreduce.mr_beans.Bean01;
//import org.apache.hadoop.examples.pi.Combinable;
import org.apache.hadoop.mapreduce.Reducer;

/**
 * Created by hanzhiqiang on 2019/3/11.
 */
public class MyCombanier extends Reducer
//        implements Combinable<Bean01>
{
    public Bean01 combine(Bean01 bean01) {
        return null;
    }
    public int compareTo(Bean01 o) {
        return 0;
    }
}




