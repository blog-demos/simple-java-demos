package pers.hai.simple;

import org.junit.Test;

import java.util.StringTokenizer;

/**
 * TODO
 * <p>
 * Create Time: 2019-06-14 18:35
 * Last Modify: 2019-06-14
 *
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class StringTokenizerTests extends Testable {

    @Test
    public void test1() {
        StringTokenizer tokenizer = new StringTokenizer("abc def");
        while (tokenizer.hasMoreTokens()) {
            logger.info(String.format("%s", tokenizer.nextToken()));
        }
    }

    @Test
    public void test2() {
        StringTokenizer tokenizer = new StringTokenizer("1,4,3,52000,13400664-cda6-4a80-8c4c-f32dd3cae072,,,,1554707148,121.237.140.250", ",");
        while (tokenizer.hasMoreTokens()) {
            logger.info(String.format("%s", tokenizer.nextToken()));
        }
    }

    @Test
    public void test3() {
        StringTokenizer tokenizer = new StringTokenizer("1,4,3,52000,13400664-cda6-4a80-8c4c-f32dd3cae072,,,,1554707148,121.237.140.250", ",", true);
        while (tokenizer.hasMoreTokens()) {
            logger.info(String.format("%s", tokenizer.nextToken()));
        }
    }

    @Test
    public void test4() {
        StringTokenizer tokenizer = new StringTokenizer("1,4,3,52000,13400664-cda6-4a80-8c4c-f32dd3cae072,,,,1554707148,121.237.140.250", ",", true);
        while (tokenizer.hasMoreElements()) {
            logger.info(String.format("%s", tokenizer.nextElement()));
        }
    }
}
