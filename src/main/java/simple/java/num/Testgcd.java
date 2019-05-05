package simple.java.num;

/**
 * <p>
 * 欧几里得算法测试
 * </p>
 * 2015年12月28日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1
 */
public class Testgcd {
    
    private int maxCommonDivisor(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        
        return maxCommonDivisor(b, a % b);
    }

    public int maincode(int a, int b) {
        return a >= b ? maxCommonDivisor(a, b) : maxCommonDivisor(b, a);
    }

    public static void main(String[] args) {
        Testgcd tgcd = new Testgcd();
        System.out.println(tgcd.maincode(240, 161));
    }
}