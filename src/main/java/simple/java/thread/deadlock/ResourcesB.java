package simple.java.thread.deadlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

import pers.hai.util.commons.threads.ThreadUtils;

public class ResourcesB {

    // 自旋锁
    ReentrantLock lock = new ReentrantLock();
    
    public synchronized void visittingF1(ResourcesA a) {
        String name = Thread.currentThread().getName();
        System.out.println(name + "进入" + ResourcesA.class.getSimpleName() + ".visittingF1");
        ThreadUtils.sleep(1000);
        
        System.out.println(name + "试图访问 ResourcesA.visittingF2");
        a.visittingF2();
    }
    
    public synchronized void visittingF2() {
        System.out.println(Thread.currentThread().getName() + "进入" + getClass().getSimpleName() + ".visittingF2");
    }
    
    /**
     * 使用了自旋锁
     */
    public void visittingF3() {
        try {
            if (lock.tryLock(2, TimeUnit.SECONDS)) {
                System.out.println(Thread.currentThread().getName() + "进入" + getClass().getSimpleName() + ".visittingF3");
            }
        } catch (Exception e) {
            lock.unlock();
        }
    }
}
