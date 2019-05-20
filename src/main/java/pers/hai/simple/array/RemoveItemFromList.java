package pers.hai.simple.array;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 写一段代码在遍历 ArrayList时移除一个元素
 * </p>
 * 2015年12月23日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1
 */
public class RemoveItemFromList {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(String.valueOf(i + 1));
        }
        System.out.println("移除前：" + list);
        new RemoveItemFromList().remove(list, 5);
        System.out.println("移除后：" + list);
        new RemoveItemFromList().remove(list, "6");
        System.out.println("移除后：" + list);
    }
    
    private void remove(List<String> list, int index) {
        for (int i = 0; i < list.size(); i++) {
            if (i == index - 1) {
                list.remove(i);
            }
        }
    }
    
    private void remove(List<String> list, String value) {
        for (String string : list) {
            if (value.equals(string)) {
                list.remove(string);
            }
        }
    }
}
