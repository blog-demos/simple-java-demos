package pers.hai.simple.copy;

import pers.hai.util.commons.nums.RandomUtils;
import pers.hai.util.commons.obj.PersistenceUtils;

public class CopyObjectTest {

    private static final int CYCLE_TIMES = 100000000;
    
    public static void main(String[] args) {
        try {
            new CopyObjectTest().testCopyObject();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
    
    private void testCopyObject() throws CloneNotSupportedException {
        testCycleNew();
        testCycleClone();
        testCycleReader();
    }
    
    private void testCycleNew() {
        RandomUtils randomUtils = new RandomUtils();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < CYCLE_TIMES; i++) {
            new Person("小红", randomUtils.nextInt(1, i));
        }
        System.out.println("普通new生成对象耗时：" + (System.currentTimeMillis() - startTime) + "ms");
    }
    
    private void testCycleClone() {
        long startTime = System.currentTimeMillis();
        RandomUtils randomUtils = new RandomUtils();
        try {
            Person p1 = new Person("小红", 16);
            for (int i = 0; i < CYCLE_TIMES; i++) {
                Person p2 = (Person) p1.clone();
                p2.setAge(randomUtils.nextInt(1, i));
            }
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        System.out.println("clone生成对象耗时：" + (System.currentTimeMillis() - startTime) + "ms");
    }
    
    private void testCycleReader() {
        String path = "F:/Temp/person.obj";
        
        long startTime = System.currentTimeMillis();
        
        Person2 person = new Person2("小明", 15);
        PersistenceUtils.writeObject(person, path);
        for (int i = 0; i < CYCLE_TIMES; i++) {
            PersistenceUtils.readObject(path);
        }
        
        System.out.println("Serialization生成对象耗时：" + (System.currentTimeMillis() - startTime) + "ms");
    }
}
