package pers.hai.simple;

import org.junit.Test;

/**
 * TODO
 * <p>
 * Create Time: 2019-06-24 15:10
 * Last Modify: 2019-06-24
 *
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class MathTests {

    @Test
    public void test1() {
        System.out.println(Math.floor(+1.5));
        System.out.println(Math.floor(-1.5));

        System.out.println(Math.round(+1.5));
        System.out.println(Math.round(-1.5));

        System.out.println(Math.ceil(+1.5));
        System.out.println(Math.ceil(-1.5));
    }
}
