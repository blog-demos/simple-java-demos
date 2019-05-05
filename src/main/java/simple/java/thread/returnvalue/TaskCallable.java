package simple.java.thread.returnvalue;

import java.util.concurrent.Callable;

import org.core.utils.threads.ThreadUtils;

public class TaskCallable implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("calling.");
        ThreadUtils.sleep(5000);
        System.out.println("call over.");
        return 1;
    }

}
