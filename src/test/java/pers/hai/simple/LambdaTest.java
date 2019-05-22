package pers.hai.simple;

import org.junit.Test;
import pers.hai.simple.lambda.Add;

/**
 * TODO
 * <p>
 * Create Time: 2019-05-22 14:32
 * Last Modify: 2019-05-22
 *
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class LambdaTest extends Testable {

    @Test
    public void test1() {
        //logger.info(() -> 5);
        //new Thread(() -> System.out.println("Hello world !")).start();

        logger.info(new Add() {
            @Override
            public int add(int x, int y) {
                return x + y;
            }
        }.add(4, 5));
    }
}
