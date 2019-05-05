package simple.java.jvm;

/**
 * <p>
 * 《深入理解Java虚拟机》 - 3.6.1 p93
 * </p>
 * Create Date: 2016年3月31日
 * Last Modify: 2016年3月31日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1.1
 */
public class DemoMinorGC {

    private static final int _1MB = 1024 * 1024;
    
    public static void main(String[] args) {
//        testAllocation();
        testPretenureSizeThreshold();
    }
    
    /**
     * VM参数: -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     */
    @SuppressWarnings("unused")
    public static void testAllocation() {
        
        byte[] allocation1 = new byte[2 * _1MB];
        byte[] allocation2 = new byte[2 * _1MB];
        byte[] allocation3 = new byte[4 * _1MB];
        byte[] allocation4 = new byte[7 * _1MB];
//        byte[] allocation5 = new byte[4 * _1MB];
    }
    
    /**
     * VM参数: -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728
     * TODO
     */
    @SuppressWarnings("unused")
    public static void testPretenureSizeThreshold() {
        byte[] allc = new byte[4 * _1MB];
    }
}
