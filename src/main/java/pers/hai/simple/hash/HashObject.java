package pers.hai.simple.hash;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import pers.hai.util.commons.nums.RandomUtils;

public class HashObject implements Serializable {
    
    private static final long serialVersionUID = -5601459478366313444L;
    
    Map<String, Integer> map = new HashMap<>();
    HashInnerClass innerClass = new HashInnerClass(7);
    HashOutterClass outterClass = new HashOutterClass(8);
    
    public HashObject() {
        initMap();
    }
    
    private void initMap() {
        RandomUtils randomUtils = new RandomUtils();
        
        map.put("baidu", randomUtils.nextInt(0, 100));
        map.put("google", randomUtils.nextInt(0, 100));
        map.put("apple", randomUtils.nextInt(0, 100));
    }
    
    public void add(String key, int value) {
        if (map == null) {
            return;
        }
        
        map.put(key, value);
    }
    
    public boolean contains(String key) {
        if (map == null) {
            return false;
        }
        
        return map.containsKey(key);
    }
    
    public class HashInnerClass {
        private int var = 0;
        
        public HashInnerClass(int var) {
            this.var = var;
        }
        
        public int getVar() {
            return var;
        }
    }
}
