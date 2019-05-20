package pers.hai.simple.jvm;

/**
 * <p>
 * 《深入理解Java虚拟机》 - 7.3.5 p226
 * </p>
 * Create Date: 2016年4月7日
 * Last Modify: 2016年4月7日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1.1
 */
public class DeadLoopClass {

    static {
        if (true) {
            System.out.println(Thread.currentThread() + "init DeadLoopClass");
            while(true) {
            }
        }
    }
}
