package simple.java.thread;

import java.util.HashMap;

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
public class TreadLocalTest {

    static ThreadLocal<HashMap<Integer, Integer>> map = new ThreadLocal<HashMap<Integer, Integer>>() {
        
        @Override
        protected HashMap<Integer, Integer> initialValue() {
            System.out.println(Thread.currentThread().getName() + " initialValue");
            return new HashMap<Integer, Integer>();
        }
    };

    public void run() {
        Thread[] runs = new Thread[3];
        for (int i = 0; i < runs.length; i++) {
            runs[i] = new Thread(new CustomRunnable(i));
        }
        for (int i = 0; i < runs.length; i++) {
            runs[i].start();
        }
    }

    public static class CustomRunnable implements Runnable {
        int id;

        public CustomRunnable(int _id) {
            id = _id;
        }

        public void run() {
            System.out.println(Thread.currentThread().getName() + " start");
            
            HashMap<Integer, Integer> threadMap = map.get();
            for (int i = 0; i < 10; i++) {
                threadMap.put(i, i + id * 100);
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                }
            }
            
            System.out.println(Thread.currentThread().getName() + ": " + threadMap);
        }
    }

    public static void main(String[] args) {
        TreadLocalTest test = new TreadLocalTest();
        test.run();
    }
}