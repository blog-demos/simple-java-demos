package simple.java.jvm;

/**
 * <p>
 * VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * </p>
 * Create Date: 2016年3月30日
 * Last Modify: 2016年3月30日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1.1
 */
public class HeapOOM {

    static class OOMObject {
    }
    
    public static void main(String[] args) {
        String s = new StringBuilder("ja").append("va").toString();
        System.out.println(s.intern() == s);
//        List<OOMObject> list = new ArrayList<OOMObject>();
//        while (true) {
//            list.add(new OOMObject());
//        }
    }
}
