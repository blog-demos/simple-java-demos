package pers.hai.simple.jdk.zipapis;

import java.util.zip.CRC32;

/**
 * <p>
 * 测试 java.util.zip 包下的相关 API
 * </p>
 * Create Date: 2016年5月5日
 * Last Modify: 2016年5月5日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.0.1
 */
public class DemoUtilzip {

    public static void main(String[] args) {
        testCRC32();
    }
    
    // TODO ---------------------------------------- Separated -------------------------------------------------
    public static void testCRC32() {
        CRC32 checksum = new CRC32();
        checksum.update("Hello".getBytes());
        System.out.println(checksum.getValue());
    }
}
