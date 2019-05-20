package pers.hai.simple.num;

import pers.hai.util.commons.logs.LogUtils;

/**
 * <p>
 * 测试乘2与向左位移1位的效率
 * </p>
 * 2015年12月9日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="https://qwhai.blog.csdn.net/">https://qwhai.blog.csdn.net/</a>
 * @version 0.1
 */
public class Displacement {

    static final long TIMES = 100000000L;
    
    private static void test1() {
        int a = 123;
        int b = 0;
        
        long startStamp = System.currentTimeMillis();
        for (int i = 0; i < TIMES; i++) {
            b = a * 16;
        }
        LogUtils.printTimeUsed("b = " + b + "\n[1]", startStamp);
    }
    
    private static void test2() {
        int a = 123;
        int b = 0;
        
        long startStamp = System.currentTimeMillis();
        for (int i = 0; i < TIMES; i++) {
            b = a << 4;
        }
        LogUtils.printTimeUsed("b = " + b + "\n[2]", startStamp);
    }
    
    public static void main(String[] args) {
        test1();
        test2();
    }
}
