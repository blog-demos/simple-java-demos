package simple.java.sampling;

import java.util.ArrayList;
import java.util.List;

import pers.hai.util.commons.logs.LogUtils;
import pers.hai.util.commons.nums.RandomUtils;
import pers.hai.util.commons.threads.ThreadUtils;

/**
 * <p>
 * 随机取样测试
 * </p>
 * 2015年12月22日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1
 */
public class RandomSampling {

    public static void main(String[] args) {
        RandomSampling random = new RandomSampling();
        
        System.out.println(random.simpleRandom(5, 16, 8) + "\n");
        ThreadUtils.sleep(50);
        
        random.checkRandom(5, 16, 8);
        System.out.println();
        ThreadUtils.sleep(50);
        
        random.removeRandom(5, 16, 8);
        System.out.println();
        ThreadUtils.sleep(50);
        
        random.statusRandom(5, 16, 8);
        System.out.println();
        ThreadUtils.sleep(50);
        
        random.floydRandom(5, 16, 8);
        System.out.println();
        ThreadUtils.sleep(50);
        
        random.iterationFloyd(5, 16, 8);
    }
    
    // 1
    private List<Integer> simpleRandom(int start, int end, int count) {
        long startStamp = System.nanoTime();
        System.out.println("朴素随机算法：");
        RandomUtils randomUtils = new RandomUtils();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            int random = randomUtils.nextInt(start, end);
            list.add(random);
        }
        LogUtils.printNanoTimeUsed("朴素随机算法", startStamp);
        
        return list;
    }
    
    // 2
    private void checkRandom(int start, int end, int count) {
        long startStamp = System.nanoTime();
        System.out.println("检查存在性随机算法：");
        RandomUtils randomUtils = new RandomUtils();
        StringBuffer buffer = new StringBuffer();
        List<Integer> save = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            int random = randomUtils.nextInt(start, end);
            if (exits(save, random)) {
                i--;
                continue;
            }
            
            save.add(random);
            buffer.append(i == 0 ? ("[" + random) : (", " + random));
        }
        buffer.append("]");
        System.out.println(buffer);
        LogUtils.printNanoTimeUsed("检查存在性随机算法", startStamp);
    }
    
    // 3
    private void removeRandom(int start, int end, int count) {
        long startStamp = System.nanoTime();
        System.out.println("元素移除随机算法：");
        RandomUtils randomUtils = new RandomUtils();
        StringBuffer buffer = new StringBuffer();
        List<Integer> numbers = initList(start, end);
        for (int i = 0; i < count; i++) {
            int random = randomUtils.nextInt(0, count - i);
            buffer.append(i == 0 ? ("[" + numbers.get(random)) : (", " + numbers.get(random)));
            numbers.remove(random);
        }
        
        buffer.append("]");
        System.out.println(buffer);
        LogUtils.printNanoTimeUsed("元素移除随机算法", startStamp);
    }
    
    // 4
    private void statusRandom(int start, int end, int count) {
        long startStamp = System.nanoTime();
        System.out.println("状态转移随机算法：");
        RandomUtils randomUtils = new RandomUtils();
        StringBuffer buffer = new StringBuffer();
        int[] status = new int[end + 1];
        for (int i = 0; i < count; i++) {
            int random = randomUtils.nextInt(start, end);
            if (status[random] == 0) {
                buffer.append(i == 0 ? ("[" + random) : (", " + random));
                status[random] = random == end ? start : (random + 1); // 不可能有在start之前的数字
            } else {
                // 状态转移
                int index = random;
                do {
                    index = status[index];
                } while (status[index] != 0);
                
                buffer.append(i == 0 ? ("[" + index) : (", " + index));
                status[index] = index == end ? start : (index + 1); // 不可能有在start之前的数字
            }
        }
        
        buffer.append("]");
        System.out.println(buffer);
        LogUtils.printNanoTimeUsed("状态转移随机算法", startStamp);
    }
    
    // 5(p125)
    private void floydRandom(int start, int end, int count) {
        long startStamp = System.nanoTime();
        System.out.println("递归Floyd随机算法：");
        List<Integer> list = new ArrayList<>();
        list = simpleFloyd(list, count, start, end);
        System.out.println(list);
        LogUtils.printNanoTimeUsed("递归Floyd随机算法", startStamp);
    }
    
    // Floyd
    private List<Integer> simpleFloyd(List<Integer> list, int count, int start, int end) {
        if (count == 0) {
            return list;
        }
        list = simpleFloyd(list, count - 1, start, end - 1);
        int random = new RandomUtils().nextInt(start, end);
        if (list.contains(random)) {
            list.add(end);
        } else {
            list.add(random);
        }
        return list;
    }
    
    private List<Integer> iterationFloyd(int start, int end, int count) {
        long startStamp = System.nanoTime();
        System.out.println("迭代Floyd随机算法：");
        RandomUtils randomUtils = new RandomUtils();
        List<Integer> list = new ArrayList<>();
        for (int i = end - count + 1; i < end; i++) {
            int random = randomUtils.nextInt(start, i);
            if (list.contains(random)) {
                list.add(i);
            } else {
                list.add(random);
            }
        }
        
        System.out.println(list);
        
        LogUtils.printNanoTimeUsed("迭代Floyd随机算法", startStamp);
        return list;
    }
    
    private boolean exits(List<Integer> array, int number) {
        for (int i : array) {
            if (number == i) {
                return true;
            }
        }
        
        return false;
    }
    
    private List<Integer> initList(int start, int end) {
        List<Integer> list = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            list.add(i);
        }
        
        return list;
    }
}
