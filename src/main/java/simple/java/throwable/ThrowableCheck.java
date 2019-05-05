package simple.java.throwable;

/**
 * <p>
 * 使用Throwable获得栈信息测试
 * </p>
 * 2015年12月10日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1
 */
public class ThrowableCheck {

    public static void checkCall() {
        // 获得当前栈信息
        StackTraceElement[] elements = new Throwable().getStackTrace();
        
        String method = "";
        for (StackTraceElement element : elements) {
            method = element.getClassName() + "." + element.getMethodName();
            if (method.equals(ClassA.class.getName() + ".callCheck")) {
                System.out.println("这是来自ClassA的callCheck方法调用。");
            } else if (method.equals(ClassB.class.getName() + ".callCheck")) {
                System.out.println("这是来自ClassB的callCheck方法调用。");
            }
        }
    }
}
