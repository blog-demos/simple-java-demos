package simple.java;

import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.Set;
import java.util.TreeMap;

/**
 * @Author: Q-WHai
 * @Date: Created in 18:10 2019/05/05
 */
public class TreeMapTest {

    private final Logger logger = Logger.getLogger(TreeMapTest.class);

    @Test
    public void test1() {
        TreeMap<String, Integer> stringKeyMap = new TreeMap<>();
        stringKeyMap.put("a", 12);
        stringKeyMap.put("b", 10);
        stringKeyMap.put("c", 20);
        stringKeyMap.put("g", 11);
        stringKeyMap.put("d", 21);
        stringKeyMap.put("e", 18);
        stringKeyMap.put("f", 13);
        logger.info(String.format("基于String排序：%s", stringKeyMap));

        TreeMap<Integer, String> intKeyMap = new TreeMap<>();
        Set<String> set = stringKeyMap.keySet();
        for (String key : set) {
            intKeyMap.put(stringKeyMap.get(key), key);
        }
        logger.info(String.format("基于Integer排序：%s", intKeyMap));
    }
}
