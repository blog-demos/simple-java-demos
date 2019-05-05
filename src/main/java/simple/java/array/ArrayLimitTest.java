package simple.java.array;

import org.core.utils.nums.RandomUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试指定和不指定List容量的情况下
 * 分别耗时情况
 * 
 * @author Naga
 * Blog : http://blog.csdn.net/lemon_tree12138
 */
public class ArrayLimitTest {

    private static final int CYCLE_TIMES = 30000000;
    
    public static void main(String[] args) {
        ArrayLimitTest test = new ArrayLimitTest();
        test.testNoLimit();
        test.testHaveLimit();
    }
    
    private void testNoLimit() {
        long startStamp = System.currentTimeMillis();
        List<Integer> list = new ArrayList<>();
        RandomUtils randomUtils = new RandomUtils();
        for (int i = 1; i <= CYCLE_TIMES; i++) {
            list.add(randomUtils.nextInt(0, i));
        }
        System.out.println("不指定容量的情况下，耗时：" + (System.currentTimeMillis() - startStamp) + "ms");
    }
    
    private void testHaveLimit() {
        long startStamp = System.currentTimeMillis();
        RandomUtils randomUtils = new RandomUtils();
        List<Integer> list = new ArrayList<>(CYCLE_TIMES);
        for (int i = 1; i <= CYCLE_TIMES; i++) {
            list.add(randomUtils.nextInt(0, i));
        }
        System.out.println("指定容量的情况下，耗时：" + (System.currentTimeMillis() - startStamp) + "ms");
    }
}
