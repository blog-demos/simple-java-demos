package simple.java.bloom;

import java.io.Serializable;
import java.util.BitSet;

/**
 * 布隆过滤器
 * 用于一些去重过滤
 * 
 * @author Naga
 * Blog : http://blog.csdn.net/lemon_tree12138
 */
public class BloomFilter implements Serializable {
    
    private static final long serialVersionUID = 6221102459061301833L;

    /* BitSet初始分配2^24个bit */
    private static final int DEFAULT_SIZE = 1 << 25;
    
    /* 不同哈希函数的种子，一般应取质数 */
    private static final int[] seeds = new int[] { 5, 7, 11, 13, 31, 37, 61 };
    
    private BitSet mBitSet = new BitSet(DEFAULT_SIZE);
    
    /* 哈希函数对象 */
    private SimpleHash[] mHashs = new SimpleHash[seeds.length];

    /**
     * 构造器
     */
    public BloomFilter() {
        for (int i = 0; i < seeds.length; i++) {
            mHashs[i] = new SimpleHash(DEFAULT_SIZE, seeds[i]);
        }
    }

    /**
     * 将字符串标记到bits中
     * 
     * @param value
     *          待添加到过滤器中的字符串
     */
    public void add(String value) {
        for (SimpleHash f : mHashs) {
            mBitSet.set(f.hash(value), true);
        }
    }

    /**
     * 判断字符串是否已经被bits标记
     * 
     * @param value
     *          待判断的字符串
     * @return
     *          返回是否被标记的结果
     */
    public boolean contains(String value) {
        if (value == null) {
            return false;
        }
        
        boolean ret = true;
        for (SimpleHash f : mHashs) {
            ret = ret && mBitSet.get(f.hash(value));
        }
        
        return ret;
    }

    /**
     * 哈希函数类
     */
    public static class SimpleHash implements Serializable {
        
        private static final long serialVersionUID = -32344263907328142L;
        private int cap;
        private int seed;

        public SimpleHash(int cap, int seed) {
            this.cap = cap;
            this.seed = seed;
        }

        /**
         * hash函数，采用简单的加权和hash
         * 
         * @param value
         *          待哈希的字符串
         * @return
         *          返回哈希的整型结果
         */
        public int hash(String value) {
            int result = 0;
            int len = value.length();
            for (int i = 0; i < len; i++) {
                result = seed * result + value.charAt(i);
            }
            return (cap - 1) & result;
        }
    }
}