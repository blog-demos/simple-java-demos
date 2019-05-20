package pers.hai.simple.math;

/**
 * <p>
 * 阶乘
 * </p>
 * 2015年12月9日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1
 */
public class FactorialDemo {
    
    public static void factorialCalculater(int n) {
        int RAD = 10000;
        int buffSize = (int) (n * Math.log10((n + 1) / 2) / Math.log10(RAD) + 1);
        short[] buff = new short[buffSize];
        int len = 1;
        buff[0] = 1;
        for (int i = 1; i <= n; i++) {
            int c = 0;
            for (int j = 0; j < len; j++) {
                int prod = (buff[j] * i + c);
                buff[j] = (short) (prod % RAD);
                c = prod / RAD;
            }
            while (c > 0) {
                buff[len++] = (short) (c % RAD);
                c = c / RAD;
            }
        }

        System.out.printf("%d!=%d", n, buff[len - 1]);
        for (int i = len - 2; i >= 0; i--) {
            System.out.printf("%04d", buff[i]);
        }
    }

    public static void main(String[] args) {
//        factorialCalculater(1493);
        factorialCalculater(100);
    }
}