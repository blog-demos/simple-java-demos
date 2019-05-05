package simple.java.interview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.core.utils.nums.NumberUtils;

/**
 * <p>
 * </p>
 * Create Date: 2016年7月4日
 * Last Modify: 2016年7月4日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.0.1
 */
public class LuckyWord {

    public static void main(String[] args) throws IOException {
        new LuckyWord().luckyWord();
    }
    
    private void luckyWord() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String label = "";
        while((label = reader.readLine()) != "EOF") {
            int[] flags = new int[26];
            char[] labelChars = label.toCharArray();
            for (char c : labelChars) {
                flags[c - 'a']++;
            }
            
            int maxn = -1;
            int minn = labelChars.length;
            for (int count : flags) {
                if (count == 0) {
                    continue;
                }
                
                if (count >= maxn) {
                    maxn = count;
                }
                
                if (count <= minn) {
                    minn = count;
                }
            }
            
            System.out.println(NumberUtils.PrimeUtils.isPrime(maxn - minn) ? "Lucky Word\n" + (maxn - minn) : "No Answer\n" + (maxn - minn));
        }
    }
}
