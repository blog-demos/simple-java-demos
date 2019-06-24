package pers.hai.simple.thread.t2;

/**
 * TODO
 * <p>
 * Create Time: 2019-06-24 11:05
 * Last Modify: 2019-06-24
 *
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class CustomRunnable implements Runnable {

    @Override
    public void run() {
        while (true) {
            printThreadInfo();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void printThreadInfo() {
        System.out.println("当前运行的线程名为： " + Thread.currentThread().getName());
    }
}
