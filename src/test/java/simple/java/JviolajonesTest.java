package simple.java;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Description TODO
 * @Author: Q-WHai
 * @Date: Created in 14:25 2019/05/06
 */
public class JviolajonesTest {

    @Test
    public void test1() {
        String a = "A";
        String b = new String("A");
        Assert.assertSame(a.intern(), b.intern());
    }
}
