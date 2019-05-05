package simple.java.thread;

import java.util.Random;

/**
 * <p>
 * ThreadGroup 测试
 * </p>
 * Create Date: 2016年5月3日 Last Modify: 2016年5月3日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.0.1
 */
public class DemoThreadGroup {

    public static void main(String[] args) {
        ThreadGroup group = new ThreadGroup("Group-0");

        for (int i = 1; i <= 10; i++) {
            new Thread(group, new GroupThreadMem(), i + "#线程").start();
        }

        while (group.activeCount() > 0) {
            System.out.println("group 的当前的活跃数量：" + group.activeCount());
        }
        System.out.println("== group 中所有线程执行结束 ==");
    }
}

/**
 * <p>
 * 自定义的 Runnable
 * </p>
 * Create Date: 2016年5月3日
 * Last Modify: 2016年5月3日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.0.1
 */
class GroupThreadMem implements Runnable {

    @Override
    public void run() {
        int times = new Random().nextInt(10);
        while (times-- > 0) {
            try {
                Thread.sleep(1);
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
