package simple.java.algor;

import pers.hai.util.commons.containers.ArrayUtils;
import pers.hai.util.commons.sort.impl.QKSort;
import pers.hai.util.commons.sort.poke.SortUtils;

import java.util.Arrays;

/**
 * <p>
 * 全排列非递归测试
 * </p>
 * Create Date: 2016年3月25日
 * Last Modify: 2016年3月25日
 *
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @version 0.1.1
 * @see <a href="https://qwhai.blog.csdn.net/">https://qwhai.blog.csdn.net/</a>
 */
public class FullPermutation2 {

    public void permutation(int[] array) {
        // 先排序
        SortUtils sortUtils = new SortUtils(new QKSort());
        sortUtils.sort(array);

        System.out.println(Arrays.toString(array)); // 最初始的序列
        do {
            nextArray(array);
            System.out.println(Arrays.toString(array));
        } while (!isLast(array));
    }

    // 计算下一个序列
    private int[] nextArray(int[] array) {
        int length = array.length;
        // 寻找替换点
        int cursor = 0;
        for (int i = length - 1; i >= 1; i--) {
            // 找到第一个递增的元素对
            if (array[i - 1] < array[i]) {
                cursor = i - 1; // 找到替换点
                break;
            }
        }

        // 寻找在替换点后面的次小元素
        int biggerCursor = cursor + 1;
        for (int i = cursor + 1; i < length; i++) {
            if (array[cursor] < array[i] && array[i] < array[biggerCursor]) {
                biggerCursor = i;
            }
        }

        // 交换
        ArrayUtils.swap(array, cursor, biggerCursor);

        // 对替换点之后的序列进行反转
        reverse(array, cursor);

        return array;
    }

    private void reverse(int[] array, int cursor) {
        int end = array.length - 1;
        for (int i = cursor + 1; i <= end; i++, end--) {
            ArrayUtils.swap(array, i, end);
        }
    }

    // 是否是最大的序列
    private boolean isLast(int[] array) {
        int length = array.length;
        for (int i = 1; i < length; i++) {
            if (array[i - 1] < array[i]) {
                return false;
            }
        }
        return true;
    }
}
