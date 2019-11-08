package array;

import java.util.Arrays;

/**
 * @author kinden
 *
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
 *
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 */
public class MinSubArrayLen {

    public static void main(String[] args) {

//        int[] arr = {2,3,1,6,4,3};

//        int[] arr = {2,3,1,7,4,3};

//        int[] arr = {2,3,1,2,4,3};

        int[] arr = {5,1,3,5,10,7,4,9,2,8};

        int res = minSubArrayLen(15, arr);

        System.out.println(res);
    }

    public static int minSubArrayLen(int s, int[] nums) {

        int len = nums.length;

        int sum = 0;
        int min = Integer.MAX_VALUE;
        int left = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            while (sum >= s) {
                min = Math.min(min, i - left + 1);
                sum -= nums[left++];
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }

}
