package pers.hai.simple;

import org.apache.log4j.Logger;
import pers.hai.util.commons.obj.SerializationUtils;
import org.junit.Test;
import pers.hai.simple.bloom.BloomFilter;

/**
 * @Author: Q-WHai
 * @Date: Created in 18:15 2019/05/05
 */
public class BloomFilterTest {

    private final Logger logger = Logger.getLogger(BloomFilterTest.class);

    @Test
    public void test1() {
        String path = "H:/2/bloom.obj";
        testWriteBloomFilter(path);

        BloomFilter readFilter = testReadBloomFilter(path);
        boolean b1 = readFilter.contains("baidu");
        boolean b2 = readFilter.contains("google");
        boolean b3 = readFilter.contains("naga");
        boolean b4 = readFilter.contains("hello");
        boolean b5 = readFilter.contains("world");
        boolean b6 = readFilter.contains("java");

        logger.info(String.format("[%s, %s, %s, %s, %s, %s]", b1, b2, b3, b4, b5, b6));
    }

    private void testWriteBloomFilter(String path) {
        BloomFilter filter = new BloomFilter();
        filter.add("baidu");
        filter.add("google");
        filter.add("naga");
        filter.add("hello");
        filter.add("world");

        SerializationUtils.writeObject(filter, path);
    }

    private BloomFilter testReadBloomFilter(String path) {
        Object object = SerializationUtils.readObject(path);
        return (BloomFilter)object;
    }
}
