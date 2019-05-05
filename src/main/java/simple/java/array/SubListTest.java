package simple.java.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 测试使用subList处理局部列表
 * 
 * @author Naga
 * Blog : http://blog.csdn.net/lemon_tree12138
 */
public class SubListTest {

    public static void main(String[] args) {
        // 初始化一个固定长度的列表
        List<Integer> initData = Collections.nCopies(1000, 0);
        
        // 转成可变长度的列表
        List<Integer> list = new ArrayList<>(initData);
        for (int i = 20; i < Math.min(list.size(), 30); i++) {
            list.remove(i);
        }
        
        System.out.println(list.size());
        
        list.subList(20, 30).clear();
        System.out.println(list.size());
    }
}
