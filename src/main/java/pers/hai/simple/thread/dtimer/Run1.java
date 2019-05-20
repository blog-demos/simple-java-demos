package pers.hai.simple.thread.dtimer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Run1 {

    private static Timer timer = new Timer();
    
    public static class MyTask extends TimerTask {

        @Override
        public void run() {
            System.out.println("运行时间：" + new Date());
        }
    }
    
    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        MyTask task = new MyTask();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = "2016-3-29 09:06:00";
        try {
            Date dateRef = format.parse(dateString);
            System.out.println("字符串时间：" + dateRef.toLocaleString() + "\n当前时间：" + new Date().toLocaleString());
            timer.schedule(task, dateRef);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
