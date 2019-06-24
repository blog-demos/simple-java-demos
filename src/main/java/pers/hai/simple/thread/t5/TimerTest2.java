package pers.hai.simple.thread.t5;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * TODO
 * <p>
 * Create Time: 2019-06-24 11:44
 * Last Modify: 2019-06-24
 *
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class TimerTest2 {

    public static void main(String[] args) {
        TimerTest2 test = new TimerTest2();
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                test.printThreadInfo();
            }
        }, new Date(), 1000);
    }

    private void printThreadInfo() {
        System.out.println("当前运行的线程名为： " + Thread.currentThread().getName());
    }
}
