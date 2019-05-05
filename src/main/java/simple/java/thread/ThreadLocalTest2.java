package simple.java.thread;

/**
 * <p>
 * ThreadLocal 测试
 * </p>
 * Create Date: 2016年5月3日
 * Last Modify: 2016年5月3日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.0.1
 */
public class ThreadLocalTest2 {

    ThreadLocal<Long> longLocal = new ThreadLocal<Long>();
    ThreadLocal<String> stringLocal = new ThreadLocal<String>();

    public void set() {
        longLocal.set(Thread.currentThread().getId());
        stringLocal.set(Thread.currentThread().getName());
    }

    public long getLong() {
        return longLocal.get();
    }

    public String getString() {
        return stringLocal.get();
    }

    public static void main(String[] args) throws InterruptedException {
        final ThreadLocalTest2 test = new ThreadLocalTest2();

        test.set();

        Thread thread1 = new Thread() {
            public void run() {
                test.set();
                System.out.println("{ id: " + test.getLong() + ", label: " + test.getString() + " }");
            };
        };
        thread1.start();
        thread1.join();

        System.out.println("{ id: " + test.getLong() + ", label: " + test.getString() + " }");
    }
}
