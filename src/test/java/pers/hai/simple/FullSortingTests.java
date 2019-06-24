package pers.hai.simple;

import org.junit.Test;
import pers.hai.simple.algor.FullSortingRecursion;
import pers.hai.simple.algor.FullSortingUnrecursion;

/**
 * Create Date: 2019-05-05 16:21
 * Last Modify: 2019-06-24
 *
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class FullSortingTests {

    @Test
    public void test1() {
        int[] array = {1, 2, 2, 2};
        new FullSortingRecursion().sorting(array);
    }

    @Test
    public void test2() {
        int[] array = {2, 1, 0};
        new FullSortingUnrecursion().sorting(array);
    }
}
