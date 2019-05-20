package pers.hai.simple.math;

import java.util.Scanner;

/**
 * <p>
 * 大数乘法
 * </p>
 * 2015年12月9日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1
 */
public class Karatsuba {
    
    // 把两个数字各分为两部分x0,x1;y0,y1
    public static int[] divideNum(int num0, int num1){
        int[] divided = new int[5];
        
        String intStr0 = String.valueOf(num0);
        String intStr1 = String.valueOf(num1);
        
        int length = Math.max(intStr0.length(), intStr1.length());
        length = (length/2)+(length%2);
        
        divided[1] = (int)(num0 % Math.pow(10, length));
        divided[0] = (int)(num0 / Math.pow(10, length));
        
        divided[3] = (int)(num1 % Math.pow(10, length));
        divided[2] = (int)(num1 / Math.pow(10, length));
        
        divided[4] = length;
        
        return divided;
    }
    
    public static void main(String args[]){
        System.out.print("Enter the num0:");
        Scanner sc = new Scanner(System.in);
        int num0 = sc.nextInt();
        System.out.print("Enter the num1:");
        int num1 = sc.nextInt();
        
        int[] x = divideNum(num0, num1);
        
        
        int z0 = x[0]*x[2];
        int z2 = x[1]*x[3];
        int z1 = (x[0]+x[1])*(x[2]+x[3])-z0-z2;
        int length = x[4];
        
        long result = (long)(Math.pow(10, length*2))*z0 + (long)(Math.pow(10, length))*z1 + z2;
        System.out.println("The result is: "+result);
        sc.close();
    }
}