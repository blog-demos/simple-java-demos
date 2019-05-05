package simple.java.thread.singleton;

public class Client {

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Createable());
        thread1.start();
        
        Thread thread2 = new Thread(new Createable());
        thread2.start();
    }
}
