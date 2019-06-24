package pers.hai.simple.thread.t7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * TODO
 * <p>
 * Create Time: 2019-06-24 12:00
 * Last Modify: 2019-06-24
 *
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class ThreadPoolTest {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);

        while (true) {
            service.execute(() -> new ThreadPoolTest().printThreadInfo());
        }
    }

    private void printThreadInfo() {
        System.out.println("当前运行的线程名为： " + Thread.currentThread().getName());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
