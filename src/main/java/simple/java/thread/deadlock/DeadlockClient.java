package simple.java.thread.deadlock;

public class DeadlockClient {

    public static void main(String[] args) {
        final ResourcesA a = new ResourcesA();
        final ResourcesB b = new ResourcesB();
        
        new Thread(new Runnable() {
            
            @Override
            public void run() {
                a.visittingF1(b);
            }
        }, "<线程-0>").start();
        
        new Thread(new Runnable() {
            
            @Override
            public void run() {
                b.visittingF1(a);
            }
        }, "<线程-1>").start();
    }
}
