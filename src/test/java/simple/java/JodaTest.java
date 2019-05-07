package simple.java;

import org.apache.log4j.Logger;
import org.joda.time.DateTimeZone;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Description TODO
 * @Author: Q-WHai
 * @Date: Created in 14:27 2019/05/06
 */
public class JodaTest {

    private final Logger logger = Logger.getLogger(JodaTest.class);

    @Test
    public void test1() {
        DateTimeZone zone = DateTimeZone.UTC;
        logger.info(zone.getName(System.currentTimeMillis(), Locale.FRANCE));
    }

    @Test
    public void test2() {
        SimpleDateFormat foo = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        logger.info(String.format("foo: %s", foo.format(new Date())));
    }

    @Test
    public void test3() {
        Calendar gc = GregorianCalendar.getInstance();

        logger.info(String.format("gc.getTime(): %s", gc.getTime()));
        logger.info(String.format("gc.getTimeInMillis(): %s", new Date(gc.getTimeInMillis())));
    }

    @Test
    public void test4() {
        // 当前系统默认时区的时间：
        Calendar calendar = new GregorianCalendar();

        logger.info(String.format("时区：%s 时间：%s:%s", calendar.getTimeZone().getID(), calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE)));
        // 美国洛杉矶时区
        TimeZone tz = TimeZone.getTimeZone("America/Los_Angeles");
        // 时区转换
        calendar.setTimeZone(tz);
        logger.info(String.format("时区：%s 时间：%s:%s", calendar.getTimeZone().getID(), calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE)));
    }

    @Test
    public void test5() {
        // 1、取得本地时间：
        java.util.Calendar cal = java.util.Calendar.getInstance();

        // 2、取得时间偏移量：
        int zoneOffset = cal.get(java.util.Calendar.ZONE_OFFSET);

        // 3、取得夏令时差：
        int dstOffset = cal.get(java.util.Calendar.DST_OFFSET);

        // 4、从本地时间里扣除这些差量，即可以取得UTC时间：
        cal.add(java.util.Calendar.MILLISECOND, -(zoneOffset + dstOffset));

        // 之后调用cal.get(int x)或cal.getTimeInMillis()方法所取得的时间即是UTC标准时间。
        logger.info(String.format("UTC: %s", new Date(cal.getTimeInMillis())));
    }

    @Test
    public void test6() {
        // 当前系统默认时区的时间：
        Calendar calendar = new GregorianCalendar();
        Calendar calendar1 = Calendar.getInstance();
        TimeZone tztz = TimeZone.getTimeZone("GMT");
        calendar1.setTimeZone(tztz);

        logger.info(calendar.getTime());
        logger.info(calendar.getTimeInMillis());
    }

    @Test
    public void test7() {
        try {
            SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
            Date t = new Date();
            logger.info(df1.format(t));
            logger.info(df1.format(df1.parse("2014-08-27T18:02:59.676Z")) + "***********");
            df1.setTimeZone(TimeZone.getTimeZone("UTC"));
            logger.info(df1.format(t));
            logger.info("-----------");
            logger.info(df1.format(df1.parse("2014-08-27T18:02:59.676Z")) + "***********");
            logger.info("2014-08-27T18:02:59.676Z");
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
    }
}
