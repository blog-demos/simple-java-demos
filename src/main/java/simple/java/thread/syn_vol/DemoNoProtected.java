package simple.java.thread.syn_vol;

public class DemoNoProtected {

    static class MyThread extends Thread {
        static int count = 0;
        
        private static void addCount() {
            for (int i = 0; i < 100; i++) {
                count++;
            }
            System.out.println("count = " + count);
        }
        
        @Override
        public void run() {
            addCount();
        }
    }
    
    public static void main(String[] args) {
        MyThread[] threads = new MyThread[100];
        for (int i = 0; i < 100; i++) {
            threads[i] = new MyThread();
        }
        
        for (int i = 0; i < 100; i++) {
            threads[i].start();
        }
    }
}
