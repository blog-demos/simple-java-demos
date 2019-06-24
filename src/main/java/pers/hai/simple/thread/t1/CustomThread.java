package pers.hai.simple.thread.t1;

/**
 * TODO
 * <p>
 * Create Time: 2019-06-24 10:53
 * Last Modify: 2019-06-24
 *
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class CustomThread extends Thread {

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
