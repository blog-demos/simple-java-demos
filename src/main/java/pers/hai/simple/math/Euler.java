package pers.hai.simple.math;

public class Euler {

    public static void main(String[] args) {
        System.out.println(euler(16));
    }
    
    private static int euler(int n) {
        int res = n, i;

        for (i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                n /= i;
                res = res - res / i;
                while (n % i == 0) {
                    n /= i;
                }
            }
        }

        if (n > 1) {
            res = res - res / n;
        }
        
        return res;
    }
}
