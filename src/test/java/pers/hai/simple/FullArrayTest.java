package pers.hai.simple;

import org.junit.Test;
import pers.hai.simple.algor.FullPermutation;
import pers.hai.simple.algor.FullPermutation2;

/**
 * @Author: Q-WHai
 * @Date: Created in 16:21 2019/05/05
 */
public class FullArrayTest {

    @Test
    public void test1() {
        int[] array = {1, 2, 2, 2};
        new FullPermutation().permutation(array);
    }

    @Test
    public void test2() {
        int[] array = {2, 1, 0};
        new FullPermutation2().permutation(array);
    }
}
