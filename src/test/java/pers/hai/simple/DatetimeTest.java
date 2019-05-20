package pers.hai.simple;

import org.apache.log4j.Logger;
import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * TODO
 * <p>
 * Create Time: 2019-05-20 17:51
 * Last Modify: 2019-05-20
 *
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class DatetimeTest {

    private final Logger logger = Logger.getLogger(DatetimeTest.class);

    // 输出格式: Mon May 20 18:02:10 CST 2019
    @Test
    public void test1() {
        logger.info(new Date());
    }

    // 输出格式: 2019年5月20日
    @Test
    public void test2() {
        DateFormat format = DateFormat.getDateInstance();
        String date = format.format(new Date());
        logger.info(date);
    }

    // 输出格式: 2019年5月20日
    @Test
    public void test3() {
        String format = DateFormat.getDateInstance(DateFormat.DEFAULT).format(new Date());
        logger.info(format);
    }

    // 输出格式: 2019年5月20日星期一
    @Test
    public void test4() {
        String format = DateFormat.getDateInstance(DateFormat.FULL).format(new Date());
        logger.info(format);
    }

    // 输出格式: 2019年5月20日星期一
    @Test
    public void test5() {
        String format = DateFormat.getDateInstance(DateFormat.ERA_FIELD).format(new Date());
        logger.info(format);
    }

    // 输出格式: 2019年5月20日
    @Test
    public void test6() {
        String format = DateFormat.getDateInstance(DateFormat.YEAR_FIELD).format(new Date());
        logger.info(format);
    }

    // 输出格式: 2019年5月20日
    @Test
    public void test7() {
        String format = DateFormat.getDateInstance(DateFormat.MONTH_FIELD).format(new Date());
        logger.info(format);
    }

    // 输出格式: 2019/5/20
    @Test
    public void test8() {
        DateFormat format = DateFormat.getDateInstance(DateFormat.DATE_FIELD);
        String date = format.format(new Date());
        logger.info(date);
    }

    // 输出格式: 2019-05-20 06:15:12
    // 输出格式: 2019年05月20日 06:15:12
    // 输出格式: 20190520061512
    @Test
    public void test9() {
        logger.info(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
        logger.info(new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss").format(new Date()));
        logger.info(new SimpleDateFormat("yyyyMMddhhmmss").format(new Date()));
    }
}
