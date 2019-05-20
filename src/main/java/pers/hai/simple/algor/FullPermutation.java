package pers.hai.simple.algor;

import pers.hai.util.commons.containers.ArrayUtils;

import java.util.Arrays;

/**
 * <p>
 * 全排列递归测试
 * </p>
 * Create Date: 2016年3月25日
 * Last Modify: 2016年3月25日
 *
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @version 0.1.1
 * @see <a href="https://qwhai.blog.csdn.net/">https://qwhai.blog.csdn.net/</a>
 */
public class FullPermutation {

    public void permutation(int[] array) {
        int length = array.length;
        fullArray(array, 0, length - 1);
    }

    private boolean swapAccepted(int[] array, int start, int end) {
        for (int i = start; i < end; i++) {
            if (array[i] == array[end]) {
                return false;
            }
        }
        return true;
    }

    private void fullArray(int[] array, int cursor, int end) {
        if (cursor == end) {
            System.out.println(Arrays.toString(array));
        } else {
            for (int i = cursor; i <= end; i++) {
                if (!swapAccepted(array, cursor, i)) {
                    continue;
                }
                ArrayUtils.swap(array, cursor, i);
                fullArray(array, cursor + 1, end);
                ArrayUtils.swap(array, cursor, i); // 用于对之前交换过的数据进行还原
            }
        }
    }

}