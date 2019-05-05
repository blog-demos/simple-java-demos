package simple.java.interview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

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
public class HeapOfStones {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HeapOfStones heapOfStones = new HeapOfStones();
        String label = "";
        while(!(label = reader.readLine()).equals("EOF")) {
            List<Integer> stoneHeaps = parserStoneHeaps(label);
            System.out.println("最小总代价：" + heapOfStones.head(stoneHeaps));
        }
    }
    
    private int head(List<Integer> stoneHeaps) {
        int valueSum = 0;
        int mergeIndex = 0;
        while (stoneHeaps.size() > 1) {
            int minValueSum = Integer.MAX_VALUE;
            for (int i = 0; i < stoneHeaps.size() - 1; i++) {
                if ((stoneHeaps.get(i) + stoneHeaps.get(i + 1)) <= minValueSum) {
                    minValueSum = stoneHeaps.get(i) + stoneHeaps.get(i + 1);
                    mergeIndex = i;
                }
            }
            
            valueSum += minValueSum;
            stoneHeaps.set(mergeIndex, stoneHeaps.get(mergeIndex) + stoneHeaps.get(mergeIndex + 1));
            stoneHeaps.remove(mergeIndex + 1);
        }
        
        return valueSum;
    }
    
    private final static List<Integer> parserStoneHeaps(String label) {
        StringTokenizer tokenizer = new StringTokenizer(label);
        List<Integer> stoneHeaps = new ArrayList<>();
        while (tokenizer.hasMoreTokens()) {
            stoneHeaps.add(Integer.parseInt(tokenizer.nextToken()));
        }
        
        return stoneHeaps;
    }
}
