package simple.java.compar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import pers.hai.util.commons.logs.LogUtils;

/**
 * 测试对象排序
 * 
 * @author Naga
 * Blog : http://blog.csdn.net/lemon_tree12138
 */
public class ComparTest {

    static final int TIMES = 100000000;
    
    public static void main(String[] args) {
        simpleSort();
        
        collectionsSort();
        
        collectionsPositionSort();
    }
    
    // 冒泡排序
    private static void simpleSort() {
        long startStamp = System.currentTimeMillis();
        
        List<Employee2> list = new ArrayList<>(5);
        list.add(new Employee2(1011, "张三", Position.Boss));
        list.add(new Employee2(1008, "李四", Position.Manager));
        list.add(new Employee2(1009, "王五", Position.Manager));
        list.add(new Employee2(1005, "赵六", Position.Staff));
        list.add(new Employee2(1004, "孙七", Position.Staff));
        
        for (int i = 0; i < TIMES; i++) {
            sort(list);
        }
        
        System.out.println(list);
        LogUtils.printTimeUsed("Simple", startStamp);
    }
    
    // 对id基于Collections的排序
    private static void collectionsSort() {
        long startStamp = System.currentTimeMillis();
        
        List<Employee> list = new ArrayList<>(5);
        list.add(new Employee(1011, "张三", Position.Boss));
        list.add(new Employee(1008, "李四", Position.Manager));
        list.add(new Employee(1009, "王五", Position.Manager));
        list.add(new Employee(1005, "赵六", Position.Staff));
        list.add(new Employee(1004, "孙七", Position.Staff));
        
        for (int i = 0; i < TIMES; i++) {
            Collections.sort(list);
        }
        
        System.out.println(list);
        LogUtils.printTimeUsed("Collections", startStamp);
    }
    
    // 对position基于Collections的排序
    private static void collectionsPositionSort() {
        long startStamp = System.currentTimeMillis();
        
        List<Employee> list = new ArrayList<>(5);
        list.add(new Employee(1011, "张三", Position.Boss));
        list.add(new Employee(1008, "李四", Position.Manager));
        list.add(new Employee(1009, "王五", Position.Manager));
        list.add(new Employee(1005, "赵六", Position.Staff));
        list.add(new Employee(1004, "孙七", Position.Staff));
        
        for (int i = 0; i < TIMES; i++) {
            Collections.sort(list, Collections.reverseOrder(new PositionComparator()));
        }
        
        System.out.println(list);
        LogUtils.printTimeUsed("Collections", startStamp);
    }
    
    private static void sort(List<Employee2> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (i == j) {
                    continue;
                }
                
                if (list.get(i).getId() > list.get(j).getId()) {
                    swap(list, i, j);
                }
            }
        }
    }
    
    private static void swap(List<Employee2> list, int i, int j) {
        Employee2 a = list.get(i);
        Employee2 b = list.get(j);
        
        Employee2 swap = new Employee2(a.getId(), a.getName(), a.getPosition());
        a.setId(b.getId());
        a.setName(b.getName());
        a.setPosition(b.getPosition());
        
        b.setId(swap.getId());
        b.setName(swap.getName());
        b.setPosition(swap.getPosition());
    }
}
