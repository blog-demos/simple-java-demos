package simple.java.array;

import org.core.utils.logs.LogUtils;

import java.util.LinkedList;
import java.util.List;

/**
 * 测试LinkedList遍历方式的效率
 * for VS foreach
 * 
 * @author Naga
 * Blog : http://blog.csdn.net/lemon_tree12138
 */
public class LinkedListCycleTest {

    private static final int CYCLE_TIMES = 30000;
    List<String> list = new LinkedList<>();
    
    public static void main(String[] args) {
        LinkedListCycleTest test = new LinkedListCycleTest();
        test.initList();
        
        test.testCycleIndex();
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
    
    private void testCycleIterative() {
        long startStamp = System.currentTimeMillis();
        for (String string : list) {
            string = string + "ed";
        }
        
        LogUtils.printTimeUsed("ITERATIVE", startStamp);
    }
}
