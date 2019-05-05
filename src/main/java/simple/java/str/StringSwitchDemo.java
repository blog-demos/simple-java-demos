package simple.java.str;

/**
 * <p>
 * 关于字符串的Switch测试
 * </p>
 * 2015年12月23日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1
 */
public class StringSwitchDemo {

    public static void main(String[] args) {
        String key = "abc";
        
        switch (key) {
        case "abc":
            System.out.println("输入了ABC啦");
            break;

        case "bcd":
            System.out.println("输入了BCD啦");
            break;
            
        default:
            break;
        }
    }
}
