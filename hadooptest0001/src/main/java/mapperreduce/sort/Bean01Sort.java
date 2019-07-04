package mapperreduce.sort;

import mapperreduce.mr_beans.Bean01;
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

/**
 * Created by hanzhiqiang on 2019/3/11.
 */
public class Bean01Sort  extends WritableComparator{
    @Override
    public int compare(Object a, Object b) {
        Bean01 bean01a = (Bean01)a;
        Bean01 bean01b = (Bean01)b;
        if (bean01a.getAge()>bean01b.getAge()){
            return 1;
        }else {
            return -1;
        }
    }

    @Override
    public int compare(WritableComparable a, WritableComparable b) {
        return super.compare(a, b);
    }

    @Override
    public int compare(byte[] b1, int s1, int l1, byte[] b2, int s2, int l2) {
        return super.compare(b1, s1, l1, b2, s2, l2);
    }
}
