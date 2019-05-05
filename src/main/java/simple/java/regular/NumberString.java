package simple.java.regular;

import org.core.utils.logs.LogUtils;
import org.core.utils.str.StringUtils;

/**
 * <p>
 * 代码控制判断字符串和正则判断的比较测试
 * </p>
 * 2015年12月9日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1
 */
public class NumberString {

    static final long TIMES = 100L;
    
    private static void test1(String string) {
        long startStamp = System.currentTimeMillis();
        for (int i = 0; i < TIMES; i++) {
            StringUtils.RegexUtils.isNumberString(string);
        }
        LogUtils.printTimeUsed("test1", startStamp);
    }
    
    private static void test2(String string) {
        long startStamp = System.currentTimeMillis();
        for (int i = 0; i < TIMES; i++) {
            StringUtils.RegexUtils.isNumberString(string);
        }
        LogUtils.printTimeUsed("test2", startStamp);
    }
    
    public static void main(String[] args) {
        String s = "21542548523115561651518478425121";
        test1(s);
        test2(s);
    }
}
