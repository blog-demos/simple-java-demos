package pers.hai.simple.thread.t1;

/**
 * TODO
 * <p>
 * Create Time: 2019-06-24 10:55
 * Last Modify: 2019-06-24
 *
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class CustomThreadTest {

    public static void main(String[] args) {
        CustomThread thread1 = new CustomThread();
        thread1.setName("c3cea6f3-7a37-4b4c-910e-4c8589f3575e");
        thread1.start();

        CustomThread thread2 = new CustomThread();
        thread2.setName("7e0b8a3c-9ac9-4341-8017-9062716a4982");
        thread2.start();
    }
}
