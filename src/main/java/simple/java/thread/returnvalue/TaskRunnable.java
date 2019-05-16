package simple.java.thread.returnvalue;

import pers.hai.util.commons.threads.ThreadUtils;

public class TaskRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("running...");
        ThreadUtils.sleep(3000);
        System.out.println("run over.");
    }

}
