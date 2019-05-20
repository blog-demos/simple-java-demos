package pers.hai.simple.array;

/**
 * <p>
 * 求数组中一个连续子数组和的最大值
 * </p>
 * 2015年12月24日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1
 */
public class MaxSumContinuous {

    public static void main(String[] args) {
        int[] a = {2, 2, -3, 4, 6, -2, -3, 8, -1};
        System.out.println(new MaxSumContinuous().maxSum(a));
    }
    
    private int maxSum(int[] a) {
        if (a == null || a.length == 0) {
            return 0;
        }
        
        int maxEndIndex = 0;
        int maxSum = 0;
        for (int i = 0; i < a.length; i++) {
            maxEndIndex = Math.max(maxEndIndex + a[i], 0);
            maxSum = Math.max(maxSum, maxEndIndex);
        }
        
        return maxSum;
    }
}
