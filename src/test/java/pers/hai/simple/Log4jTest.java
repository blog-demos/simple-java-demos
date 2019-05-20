package pers.hai.simple;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.net.SyslogAppender;
import org.junit.Test;
import pers.hai.simple.log4j.CustomLogLevel;

/**
 * @Author: Q-WHai
 * @Date: Created in 10:34 2019/05/06
 */
public class Log4jTest {

    private final Logger logger = Logger.getLogger(Log4jTest.class);

    @Test
    public void test1() {
        logger.setLevel(Level.INFO);
        logger.info("测试[INFO]日志");
    }

    @Test
    public void test2() {
        logger.warn("测试[WARN]日志");
    }

    @Test
    public void test3() {
        logger.debug("测试[DEBUG]日志");
    }

    @Test
    public void test4() {
        logger.error("测试[ERROR]日志");
    }

    @Test
    public void test5() {
        logger.trace("测试[TRACE]日志");
    }

    @Test
    public void test6() {
        logger.fatal("测试[FATAL]日志");
    }

    @Test
    public void test7() {
        Level level = new CustomLogLevel(60000, "CUSTOMER", SyslogAppender.LOG_LOCAL0);
        logger.log(level, "测试自定义等级日志");
    }
}
