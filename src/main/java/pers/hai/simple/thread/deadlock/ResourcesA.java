package pers.hai.simple.thread.deadlock;

import pers.hai.util.commons.threads.ThreadUtils;

public class ResourcesA {

    public synchronized void visittingF1(ResourcesB b) {
        String name = Thread.currentThread().getName();
        System.out.println(name + "进入" + ResourcesA.class.getSimpleName() + ".visittingF1");
        ThreadUtils.sleep(1000);
        
        System.out.println(name + "试图访问 ResourcesB.visittingF2");
        b.visittingF2();
    }
    
    public synchronized void visittingF2() {
        System.out.println(Thread.currentThread().getName() + "进入" + getClass().getSimpleName() + "visittingF2");
    }
}
