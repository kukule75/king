package array;

import java.util.Arrays;

/**
 * @author kinden
 *
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回滑动窗口中的最大值。
 *
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 */
public class MaxSlidingWindow {

    public static void main(String[] args) {

        int[] nums = {1,3,-1,-3,5,3,6,7};
        int[] res = maxSlidingWindow(nums, 3);

        Arrays.stream(res).forEach(System.out::println);
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {

        int len = nums.length;
        if (len == 0) {
            return new int[0];
        }
        int[] res = new int[len - k + 1];

        for (int i = 0; i <= len - k; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j <= k + i - 1; j++) {
                max = nums[j] >= max ? nums[j] : max;
            }

            res[i] = max;
        }

        return res;
    }

    //看错了，看成滑动窗口内元素累加和的最大值
    public static int[] maxSlidingWindowA(int[] nums, int k) {

        int len = nums.length;
        int[] res = new int[len - k + 1];

        int max = Integer.MIN_VALUE;

        int j = 0;
        for (; j < k; j++) {
            max = nums[j] >= max ? nums[j] : max;
        }

        for (int i = j; i < len - 1; i++) {
            res[j - i] = max;
            max = nums[j] >= max ? nums[j] : max;
        }

        return res;
    }
}
