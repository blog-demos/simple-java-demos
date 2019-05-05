package simple.java.thread.deadlock;

import java.util.concurrent.atomic.AtomicReference;

public class SpinLock {

    private AtomicReference<Thread> owner = new AtomicReference<>();

    public void lock() {
        Thread currentThread = Thread.currentThread();
        // 循环cas来判断锁是否被占用，第一个为期望值，如果为null说明锁未被占用，设置当前线程占用
        while (owner.compareAndSet(null, currentThread)) {
            // 这里一般会调用java.util.concurrent.locks.AbstractOwnableSynchronizer的setExclusiveOwnerThread(Thread
            // t)方法来设置独占锁
        }
    }

    public void unlock() {
        Thread currentThread = Thread.currentThread();

        owner.compareAndSet(currentThread, null);
    }
}