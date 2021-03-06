package mapperreduce.mr_beans;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * Created by hanzhiqiang on 2019/3/11.
 */
public class Bean01 implements WritableComparable<Bean01> {
    private String name;
    private int age;
    private String depno;


    public int compareTo(Bean01 o) {
        if (this.getAge()>o.getAge()){
            return 1;
        }else {
            return -1;
        }
    }

    //注意readFields与write方法的输入与输出的顺序
    public void readFields(DataInput dataInput) throws IOException {
        //反序列化：输入
        this.name = dataInput.readUTF();
        this.age = dataInput.readInt();
        this.depno = dataInput.readUTF();
    }

    public void write(DataOutput dataOutput) throws IOException {
        //序列化：输出
        dataOutput.writeUTF(this.name);
        dataOutput.writeInt(this.age);
        dataOutput.writeUTF(this.depno);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDepno() {
        return depno;
    }

    public void setDepno(String depno) {
        this.depno = depno;
    }

    /**
     * Returns a string representation of the object. In general, the
     * {@code toString} method returns a string that
     * "textually represents" this object. The result should
     * be a concise but informative representation that is easy for a
     * person to read.
     * It is recommended that all subclasses override this method.
     * <p>
     * The {@code toString} method for class {@code Object}
     * returns a string consisting of the name of the class of which the
     * object is an instance, the at-sign character `{@code @}', and
     * the unsigned hexadecimal representation of the hash code of the
     * object. In other words, this method returns a string equal to the
     * value of:
     * <blockquote>
     * <pre>
     * getClass().getName() + '@' + Integer.toHexString(hashCode())
     * </pre></blockquote>
     *
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "{name="+this.name +",age="+this.getAge()+",depno="+this.getDepno()+"}";
    }
}
