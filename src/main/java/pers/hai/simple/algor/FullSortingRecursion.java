package pers.hai.simple.algor;

import pers.hai.util.commons.containers.ArrayUtils;

import java.util.Arrays;

/**
 * 全排列递归测试
 *
 * Create Date: 2016-03-25
 * Last Modify: 2019-06-24
 *
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class FullSortingRecursion {

    public void sorting(int[] array) {
        int length = array.length;
        fullArray(array, 0, length - 1);
    }

    private boolean swapAccepted(int[] array, int start, int end) {
        for (int i = start; i < end; i++)
            if (array[i] == array[end])
                return false;

        return true;
    }

    private void fullArray(int[] array, int cursor, int end) {
        if (cursor == end)
            System.out.println(Arrays.toString(array));
        else
            for (int i = cursor; i <= end; i++) {
                if (!swapAccepted(array, cursor, i))
                    continue;

                ArrayUtils.swap(array, cursor, i);
                fullArray(array, cursor + 1, end);
                ArrayUtils.swap(array, cursor, i); // 用于对之前交换过的数据进行还原
            }
    }
}