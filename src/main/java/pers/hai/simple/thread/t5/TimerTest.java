package pers.hai.simple.thread.t5;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;

/**
 * TODO
 * <p>
 * Create Time: 2019-06-24 11:35
 * Last Modify: 2019-06-24
 *
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class TimerTest {

    public static void main(String[] args) {
        TimerTest test = new TimerTest();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        Timer timer = new Timer();
        try {
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    test.printThreadInfo();
                }
            }, format.parse("2019-06-24 11:41:00"));
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
    }

    private void printThreadInfo() {
        System.out.println("当前运行的线程名为： " + Thread.currentThread().getName());
    }
}
