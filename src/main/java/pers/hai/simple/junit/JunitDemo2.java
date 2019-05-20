package pers.hai.simple.junit;

import junit.framework.TestCase;

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
public class JunitDemo2 extends TestCase {

    private Student testStudent;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        testStudent = new Student("steven_hu", "boy", 170, 23, "上海理工");
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testSetage() {
        assertTrue(testStudent.setAge(21));
    }

    public void testGetSchool() {
        // 预期值和实际值不一样，测试时出现失败(Failure)
        assertEquals("南昌大学", testStudent.getSchool());
    }
    
    public void testGetHigh() {
        assertEquals(170, testStudent.getHigh());
    }

    public void testGetName() {
        assertEquals("hdy", testStudent.getName());
    }
}
