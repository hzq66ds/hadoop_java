package hive.jdbc;

import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.io.Text;

/**
 * Created by hanzhiqiang on 2019/3/17.
 */
public class UDFtest2 extends UDF {
    public Text evaluate(Text a,Text b) {
        return new Text(a+"****UDFtest2**"+b);
    }
}
