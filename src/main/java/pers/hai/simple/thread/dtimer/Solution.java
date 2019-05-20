package pers.hai.simple.thread.dtimer;

import java.util.Stack;

/**
 * <p>
 * https://leetcode.com/problems/minimum-window-substring/
 * </p>
 * Create Date: 2016年3月30日
 * Last Modify: 2016年3月31日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1.1
 */
public class Solution {
    
    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        int max = new Solution().largestRectangleArea(heights);
        System.out.println(max);
    }
    
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        Stack<Integer> stack1 = new Stack<Integer>(); // 原栈
        Stack<Integer> stack2 = new Stack<Integer>(); // 辅助栈
        
        int length = heights.length;
        stack2.push(0);
        for (int i = length - 1; i >= 0; i--) {
            stack2.push(heights[i]);
        }
        
        int ascCount = 0;
        
        while (!stack2.empty()) {
            int height = stack2.pop();
            if (stack1.empty()) {
                stack1.push(height);
                ascCount = 0;
                continue;
            }
            
            int top = stack1.peek();
            if (height >= top) {
                stack1.push(height);
                ascCount = 0;
                continue;
            }
            
            stack2.push(height);
            top = stack1.pop();
            ascCount++;
//            System.out.println(top + " x " + ascCount + " = " + (top * ascCount));
            int currentS = top * ascCount;
            if (currentS > max) {
                max = currentS;
            }
            top = height;
            stack2.push(top);
        }
        
        return max;
    }
}