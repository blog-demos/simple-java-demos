package simple.java.clone;

public class CloneClient {

    public static void main(String[] args) {
        final int maxLoops = 10 * 10000;
        int loops = 0;
        long startStamp = System.nanoTime();
        
        Apple apple = new Apple();
        while(++loops <= maxLoops) {
            apple.clone();
        }
        
        long midStamp = System.nanoTime();
        while(--loops >= 0) {
            new Apple();
        }
        
        long endStamp = System.nanoTime();
        System.out.println("Clone\t" + (midStamp - startStamp) + "ns\nNew\t\t" + (endStamp - midStamp) + "ns");
    }
}
