package pers.hai.simple.thread.t6;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * TODO
 * <p>
 * Create Time: 2019-06-24 11:49
 * Last Modify: 2019-06-24
 *
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class CustomCallable {

    public static void main(String[] args) {
        CustomCallable callable = new CustomCallable();

        // 创建线程任务
        Callable<Integer> call = () -> {
            callable.printThreadInfo();
            Thread.sleep(3000);
            return 1;
        };

        // 将任务封装为FutureTask
        FutureTask<Integer> task = new FutureTask<>(call);

        // 开启线程，执行线程任务
        new Thread(task).start();

        // 获取线程结果
        Integer result = 0;
        try {
            result = task.get(); // 这里获取结果会阻塞
        } catch (InterruptedException | ExecutionException ex) {
            ex.printStackTrace();
        }

        System.out.println(String.format("result = %d", result));
    }

    private void printThreadInfo() {
        System.out.println("当前运行的线程名为： " + Thread.currentThread().getName());
    }
}
