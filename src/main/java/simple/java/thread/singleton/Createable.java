package simple.java.thread.singleton;

/**
 * <p>
 * 创建学生类的任务Runnable
 * </p>
 * Create Date: 2016年4月6日
 * Last Modify: 2016年4月7日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1.2
 */
public class Createable implements Runnable {

    @Override
    public void run() {
        Student student = Student.INSTANCE;
        System.out.println("学生类被创建：" + student);
        System.out.println("Hashcode：" + student.hashCode());
    }

}
