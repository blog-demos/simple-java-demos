package pers.hai.simple.thread.t3;

/**
 * TODO
 * <p>
 * Create Time: 2019-06-24 11:17
 * Last Modify: 2019-06-24
 *
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class RunnableLambdaTest {

    public static void main(String[] args) {

        RunnableLambdaTest test = new RunnableLambdaTest();

        Runnable runnable = () -> {
            while (true) {
                test.printThreadInfo();

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        };

        Thread thread1 = new Thread(runnable);
        thread1.setName("a0295883-ba4c-4f06-baee-2ce269f6030c");
        thread1.start();

        Thread thread2 = new Thread(runnable);
        thread2.setName("22380669-850d-4f39-bdfa-270bde31f199");
        thread2.start();
    }

    private void printThreadInfo() {
        System.out.println("当前运行的线程名为： " + Thread.currentThread().getName());
    }
}
