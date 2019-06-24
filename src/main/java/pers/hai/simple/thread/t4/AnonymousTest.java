package pers.hai.simple.thread.t4;

/**
 * TODO
 * <p>
 * Create Time: 2019-06-24 11:25
 * Last Modify: 2019-06-24
 *
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class AnonymousTest {

    public static void main(String[] args) {
        AnonymousTest test = new AnonymousTest();

        new Thread() {
            @Override
            public void run() {
                while (true) {
                    test.printThreadInfo();

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    test.printThreadInfo();

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }).start();
    }

    private void printThreadInfo() {
        System.out.println("当前运行的线程名为： " + Thread.currentThread().getName());
    }
}
