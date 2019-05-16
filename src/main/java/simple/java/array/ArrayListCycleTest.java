package simple.java.array;

import pers.hai.util.commons.logs.LogUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试ArrayList遍历方式的效率
 * for VS foreach
 * 
 * @author Naga
 * Blog : http://blog.csdn.net/lemon_tree12138
 */
public class ArrayListCycleTest {

    private static final int CYCLE_TIMES = 3000000;
    List<String> list = new ArrayList<>();
    
    public static void main(String[] args) {
        ArrayListCycleTest test = new ArrayListCycleTest();
        test.initList();
        
        test.testCycleIndex();
        test.testCycleIndex2();
        test.testCycleIterative();
    }
    
    private void initList() {
        long startStamp = System.currentTimeMillis();
        for (int i = 0; i < CYCLE_TIMES; i++) {
            list.add(i + "");
        }
        
        LogUtils.printTimeUsed("初始化", startStamp);
    }
    
    private void testCycleIndex() {
        long startStamp = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            list.get(i);
        }
        
        LogUtils.printTimeUsed("INDEX", startStamp);
    }
    
    private void testCycleIndex2() {
        long startStamp = System.currentTimeMillis();
        int len = list.size();
        for (int i = 0; i < len; i++) {
            list.get(i);
        }
        
        LogUtils.printTimeUsed("INDEX2", startStamp);
    }
    
    private void testCycleIterative() {
        long startStamp = System.currentTimeMillis();
        for (String string : list) {
            string = string + "ed";
        }
        
        LogUtils.printTimeUsed("ITERATIVE", startStamp);
    }
}
