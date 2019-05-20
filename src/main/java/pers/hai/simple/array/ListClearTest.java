package pers.hai.simple.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * List快速清空测试
 * </p>
 * 2015年12月23日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1
 */
public class ListClearTest {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println(list);
        list.clear();
        System.out.println(list);
        
        testPrintArray();
    }
    
    private static void testPrintArray() {
        int[] a = {2, 4, 9, 5, 1, 7, 12, 15, 11, 10, 3};
        System.out.println(Arrays.toString(a));
    }
}
