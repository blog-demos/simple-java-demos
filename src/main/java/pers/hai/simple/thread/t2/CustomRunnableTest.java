package pers.hai.simple.thread.t2;

/**
 * TODO
 * <p>
 * Create Time: 2019-06-24 11:07
 * Last Modify: 2019-06-24
 *
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class CustomRunnableTest {

    public static void main(String[] args) {
        CustomRunnable runnable = new CustomRunnable();
        Thread thread1 = new Thread(runnable);
        thread1.setName("685df091-9f94-42d8-9909-b142ae421f7e");
        thread1.start();

        Thread thread2 = new Thread(runnable);
        thread2.setName("c20aa233-58a1-4c2a-b83b-f5cc8957a0a5");
        thread2.start();
    }
}
