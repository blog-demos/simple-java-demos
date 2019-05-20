package pers.hai.simple.junit;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * <p>
 * 单元测试Demo
 * </p>
 * 2015年12月23日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1
 */
public class JunitComDemo {

    public static Test suite() {
        TestSuite suite = new TestSuite("Test for com.phicomme.test");
        suite.addTestSuite(JunitDemo1.class);
        suite.addTestSuite(JunitDemo2.class);
        return suite;

    }
}
