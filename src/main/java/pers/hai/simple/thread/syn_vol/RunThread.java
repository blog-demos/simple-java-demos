package pers.hai.simple.thread.syn_vol;

public class RunThread extends Thread {
    private volatile boolean isRunning = true;

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunFlag(boolean flag) {
        isRunning = flag;
    }

    @Override
    public void run() {
        System.out.println("I'm come in...");
        boolean first = true;
        while(isRunning) {
            if (first) {
                System.out.println("I'm in while...");
                first = false;
            }
        }
        System.out.println("I'll go out.");
    }
}