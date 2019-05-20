package pers.hai.simple.jvm;

/**
 * <p>
 * 《深入理解Java虚拟机》 - 7.3.5 p226
 * </p>
 * Create Date: 2016年4月7日
 * Last Modify: 2016年4月7日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1.1
 */
public class ShowDeadLoopClass {

    public static void main(String[] args) {
        Runnable script = new Runnable() {
            
            @Override
            public void run() {
                System.out.println(Thread.currentThread() + " start");
                @SuppressWarnings("unused")
                DeadLoopClass deadLoopClass = new DeadLoopClass();
                System.out.println(Thread.currentThread() + " run over");
            }
        };
        
        Thread thread1 = new Thread(script);
        Thread thread2 = new Thread(script);
        
        thread1.start();
        thread2.start();
    }
}
