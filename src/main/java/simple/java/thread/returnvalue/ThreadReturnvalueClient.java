package simple.java.thread.returnvalue;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadReturnvalueClient {

    private Thread thread = null;
    
    public static void main(String[] args) {
        ThreadReturnvalueClient client = new ThreadReturnvalueClient();
//        client.testRun();
        client.testCall();
    }
    
    @SuppressWarnings("unused")
    private void testRun() {
        thread = new Thread(new TaskRunnable());
        thread.start();
        System.out.println("start over");
    }
    
    private void testCall() {
        FutureTask<Integer> task = new FutureTask<>(new TaskCallable());
        thread = new Thread(task);
        thread.start();
        System.out.println("task start");
        
        try {
            System.out.println(task.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        
//        try {
//            while(task.get() != 1) {
//                System.out.println("线程正在执行，请稍等...");
//                ThreadUtils.sleep(100);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        
//        System.out.println("task is over");
    }
}
