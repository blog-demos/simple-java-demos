package pers.hai.simple.thread.syn_vol;

public class MyRun {
    public static void main(String[] args) throws InterruptedException {
        RunThread thread = new RunThread();
        thread.start();
        Thread.sleep(100);
        thread.setRunFlag(false);
        System.out.println("flag is reseted: " + thread.isRunning());
    }
}
