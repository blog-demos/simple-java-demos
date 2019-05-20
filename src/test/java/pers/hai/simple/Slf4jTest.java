package pers.hai.simple;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: Q-WHai
 * @Date: Created in 11:42 2019/05/06
 */
public class Slf4jTest {

    private static Logger logger = LoggerFactory.getLogger(Slf4jTest.class);

    @Test
    public void test1() {
        logger.debug("");
    }
}
