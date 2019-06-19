package pers.hai.simple;

import org.junit.Test;

import java.text.DecimalFormat;

/**
 * TODO
 * <p>
 * Create Time: 2019-06-19 18:07
 * Last Modify: 2019-06-19
 *
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class NumberTests extends Testable {

    private static final double pi = 3.1415927;
    private static final long x = 299792458;

    // 取一位整数
    @Test
    public void test1() {
        logger.info(new DecimalFormat("0").format(pi)); // 3
    }

    // 保留两位小数
    @Test
    public void test2() {
        logger.info(new DecimalFormat("0.00").format(pi)); // 3.14
    }

    // 取两位整数和三位小数，整数不足部分以0填补
    @Test
    public void test3() {
        logger.info(new DecimalFormat("00.000").format(pi)); // 03.142
    }

    // 取所有整数部分
    @Test
    public void test4() {
        logger.info(new DecimalFormat("#").format(pi)); // 3
    }

    // 显示为科学计数法，并取五位小数
    @Test
    public void test5() {
        logger.info(new DecimalFormat("#.#####E0").format(x)); // 2.99792E8
    }

    // 显示为两位整数的科学计数法，并取四位小数
    @Test
    public void test6() {
        logger.info(new DecimalFormat("00.####E0").format(x)); // 29.9792E7
    }

    // 每三位以逗号进行分隔
    @Test
    public void test7() {
        logger.info(new DecimalFormat(",###").format(x)); // 299,792,458
    }

    // 将格式嵌入文本
    @Test
    public void test8() {
        logger.info(new DecimalFormat("光速大小为每秒,###米").format(x)); // 光速大小为每秒299,792,458米
    }
}
