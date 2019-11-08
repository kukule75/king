package array;

/**
 * @author kinden
 *
 * 在一个给定的数组nums中，总是存在一个最大元素 。
 * 查找数组中的最大元素是否至少是数组中每个其他数字的两倍。
 * 如果是，则返回最大元素的索引，否则返回-1。
 * nums = [3, 6, 1, 0], 6是最大的整数, 对于数组中的其他整数,
 * 6大于数组中其他元素的两倍。6的索引是1, 所以我们返回1.
 */
public class DominantIndex {

    public static void main(String[] args) {

        int[] a = {3, 6, 1, 0};

        System.out.println(dominantIndex(a));
    }

    private static int dominantIndex(int[] a) {

        int len = a.length;

        for (int i = 0; i < len; i++) {
            int j = 0;
            for (; j < len; j++) {
                if (j != i && a[i] < a[j] * 2) {//如果自己跟自己比，因为肯定不成立
                    break;
                }
            }
            if (j == len) {//如何表示循环完了？有没有更好的方法
                return i;
            }
        }

        return -1;
    }
}
