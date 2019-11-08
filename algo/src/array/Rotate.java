package array;

import java.util.Arrays;

/**
 * @author kinden
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 *
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 */
public class Rotate {

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,6,7,8};

//        rotateA(arr, 2);

        rotateB(arr, 2);

        Arrays.stream(arr).forEach(System.out::println);
    }

    /**
     * 很自然的想到，遍历每个元素，移动到该去的位置k，那么我们首选得找到K元素应该去哪里，否则k元素丢失
     * 特殊考虑数组长度n与k之间的关系如果满足n%k==0
     *
     * @param arr
     * @param k
     */
    private static void rotateB(int[] arr, int k) {

        int len = arr.length;

        if (len == 0 || k >= len) {
            return;
        }

        int pre = 0;
        int j = 0;
        int last = 0;
        int count = 0;
        int next = 0;
        for (int i = 0; count < len; i++) {
            j = i;
            last = arr[i];
            do {
                j += k;
                next = j%len;
                pre = arr[next];//交换前需要记录后一个元素
                //swap
                arr[next] = last;
                last = pre;

                count++;
            } while (next != i);//判断是否回到原点
        }
    }

    /**
     * 这个方法基于这个事实：当我们旋转数组 k 次， k\%nk%n 个尾部元素会被移动到头部，剩下的元素会被向后移动。
     *
     * 在这个方法中，我们首先将所有元素反转。然后反转前 k 个元素，再反转后面 n-k 个元素，就能得到想要的结果。
     *
     * 假设 n=7 且 k=3 。
     * 原始数组                  : 1 2 3 4 5 6 7
     * 反转所有数字后             : 7 6 5 4 3 2 1
     * 反转前 k 个数字后          : 5 6 7 4 3 2 1
     * 反转后 n-k 个数字后        : 5 6 7 1 2 3 4 --> 结果
     *
     * 时间复杂度：O(n) 。 n 个元素被反转了总共 3 次。
     * 空间复杂度：O(1) 。 没有使用额外的空间。
     *
     * @param arr
     * @param k
     */
    private static void rotateA(int[] arr, int k) {

        int len = arr.length;

        if (len == 0 || k >= len) {
            return;
        }

        reverse(arr, 0, len - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, k, len - 1);
    }

    private static void reverse(int[] arr, int start, int end){

        int temp;

        for (int i = start, j = end; i <= j; i++, j--) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
