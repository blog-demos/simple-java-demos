package pers.hai.simple.thread.dtimer;

import java.util.concurrent.locks.LockSupport;

public class MultiThread {

    public static void main(String[] args) {
        {
            Thread currentThread = Thread.currentThread();
            LockSupport.unpark(currentThread);
            LockSupport.park();
            System.out.println("block.");
        }
        
//        {
//            ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
//            ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
//            for (ThreadInfo threadInfo : threadInfos) {
//                System.out.println("[" + threadInfo.getThreadId() + "]" + threadInfo.getThreadName());
//            }
//        }
    }
}
