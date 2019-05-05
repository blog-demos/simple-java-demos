package simple.java.math;

public class ModularPower {

    private static int[] record = new int[1 << 16];
    
    public static void main(String[] args) {
        for (int i = 0; i < record.length; i++) {
            record[i] = -1;
        }
        
        System.out.println(modularPower0(512, 211, 391));
    }
    
    private static final int modularPower0(int base, int e, int modular) {
        int result = 1;
        for (int i = 0; i < e; i++) {
            result = ((result % modular) * (base % modular)) % modular;
        }
        
        return result % modular;
    }
    
    @SuppressWarnings("unused")
    private static final int modularPower(int base, int e, int modular) {
        int result = 1;
        do {
            if (isOdd(e)) {
                result = (result * (base % modular)) % modular;
                e -= 1;
            } else {
                base = (base * base) % modular;
                e /= 2;
            }
        } while (e > 0);
        
        result %= modular;
        
        return result;
    }
    
    private static final boolean isOdd(int n) {
        return n % 2 != 0;
    }
}
