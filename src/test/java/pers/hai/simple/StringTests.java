package pers.hai.simple;

import org.junit.Test;

/**
 * TODO
 * <p>
 * Create Time: 2019-06-24 15:27
 * Last Modify: 2019-06-24
 *
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class StringTests {

    @Test
    public void test1() {
        String s0 = "Hello World";
        String s1 = "Hello World";
        String s2 = "Hello" + " " + "World";

        System.out.println(s0 == s1);
        System.out.println(s0 == s2);
    }

    @Test
    public void test2() {
        String s0 = new String("Hello World");
        String s1 = new String("Hello World");
        String s2 = "Hello" + new String(" World");

        System.out.println(s0 == s1);
        System.out.println(s0 == s2);
        System.out.println(s1 == s2);
    }

    @Test
    public void test3() {
        String s0 = "Hello World";
        String s1 = new String("Hello World").intern();
        String s2 = new String("Hello World").intern();
        String s3 = "Hello" + new String(" World").intern();

        System.out.println(s0 == s1);
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s2 == s3);
    }

    @Test
    public void test4() {
        String s = "Hello";
        StringBuilder sb = new StringBuilder(s);
        System.out.println(sb.reverse());
    }

    @Test
    public void test5() {
        String s = "Hello";
        StringBuffer sb = new StringBuffer(s);
        System.out.println(sb.reverse());
    }

    @Test
    public void test6() {
        StringBuffer sb = new StringBuffer();
        System.out.println(String.format("toStringCache: %s", sb));

        sb.append("Hello-world");
        System.out.println(String.format("toStringCache: %s", sb));
        sb.append("Hello-world2");
        System.out.println(String.format("toStringCache: %s", sb));
    }
}
