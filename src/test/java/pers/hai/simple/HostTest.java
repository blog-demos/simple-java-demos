package pers.hai.simple;

import org.apache.log4j.Logger;
import org.junit.Test;
import pers.hai.simple.host.HostUtils;

/**
 * @Description TODO
 * @Author: Q-WHai
 * @Date: Created in 14:14 2019/05/06
 */
public class HostTest {

    private final Logger logger = Logger.getLogger(HostTest.class);

    @Test
    public void test1() {
        String ip = HostUtils.getLocalHostIP();
        logger.info(ip);
    }

    @Test
    public void test2() {
        String host = HostUtils.getLocalHostName();
        logger.info(host);
    }

    @Test
    public void test3() {
        String[] ips = HostUtils.getALLLocalHostIP();
        for (String ip : ips) {
            logger.info(ip);
        }
    }
}
