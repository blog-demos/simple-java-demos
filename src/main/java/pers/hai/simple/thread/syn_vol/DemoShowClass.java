package pers.hai.simple.thread.syn_vol;

public class DemoShowClass {

    private final int x = 7;
    
    public static void main(String[] args) {
        System.out.println(new DemoShowClass().showExcep());
    }
    
    public int sum(int a, int b) {
        return a + b;
    }
    
    public int localSum(int a) {
        return x + a;
    }
    
    public int showExcep() {
        int x;
        try {
            x = 1;
            return x;
        } catch (Exception e) {
            x = 2;
            return x;
        } finally {
            x = 3;
        }
    }
}
