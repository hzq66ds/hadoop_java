package hive.jdbc;

import org.apache.hadoop.hive.ql.exec.UDFArgumentException;
import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;
import org.apache.hadoop.io.Text;
import org.apache.hive.hplsql.Udf;

/**
 * Created by hanzhiqiang on 2019/3/17.
 */
public class UDFtest extends Udf {
    @Override
    public ObjectInspector initialize(ObjectInspector[] arguments) throws UDFArgumentException {
        return super.initialize(arguments);
    }

    public Text evaluate(Text[] arguments) throws HiveException {
        return new Text(arguments[0]+"*******"+arguments[1]);
    }

    @Override
    public void initExec(DeferredObject[] arguments) throws HiveException {
        super.initExec(arguments);
    }

    @Override
    public String getDisplayString(String[] children) {
        return super.getDisplayString(children);
    }
}
