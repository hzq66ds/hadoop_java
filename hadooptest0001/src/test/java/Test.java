import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.*;

public class Test {
    public static void main(String[] args) {
        Set<Teacher> set = new HashSet<>();
        Teacher teacher1 = new Teacher();
        Teacher teacher2 = new Teacher();
        teacher1.setName("name");
        teacher1.setAge(1);
        teacher2.setName("name");
        teacher2.setAge(1);
        set.add(teacher1);
        set.add(teacher2);
//        HashMap
//        HashSet
//            ThreadLocal
//            ConcurrentHashMap

        System.out.println(teacher1.equals(teacher1)+"\t"+set.size()+"\t"+teacher1.hashCode());

    }

    public void test001(){
        try {


            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date1 = new Date();
            ThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1);
            Date date2 = new Date();
            Future<List<Teacher>> feature = executor.submit(new MyCallable());
            Date date3 = new Date();

            executor.shutdown();
            Date date4 = new Date();

            List<Teacher> aa = feature.get(2000, TimeUnit.SECONDS);
            Date date5 = new Date();

            System.out.println(format.format(date1)+"\n"+format.format(date2)+"\n"+format.format(date3)+"\n"+format.format(date4)+"\n"+format.format(date5)+"\n"+aa.size());
        }catch (Exception e){}
    }

}


class MyCallable implements Callable<List<Teacher>>{
    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    public List<Teacher> call() throws Exception {
        List<Teacher> teachers = new ArrayList<Teacher>();
        for (int i = 0;i <=10;i++){
            Teacher teacher = new Teacher();
            teacher.setName("name"+i);
            teacher.setAge(i);
            teachers.add(teacher);
            try {
                Thread.sleep(1000);
            }catch (Exception e){}
        }

        return teachers;
    }
}
class Teacher{
    private String name;
    private int age;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Teacher)) return false;
        Teacher teacher = (Teacher) o;
        return getAge() == teacher.getAge() &&
                Objects.equals(getName(), teacher.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge());
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
}