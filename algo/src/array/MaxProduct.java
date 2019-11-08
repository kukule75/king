package array;

/**
 * @author kinden
 * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 *
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 */
public class MaxProduct {

    public static void main(String[] args) {

        int[] nums = {-2,0,-1};

        System.out.println(maxProduct(nums));
    }

    public static int maxProduct(int[] nums) {

        int len = nums.length;

        int max = Integer.MIN_VALUE;
        int plus = 1;
        for (int i = 0; i < len; i++) {
            plus *= nums[i];
            max = plus >= max ? plus : max;

            if (nums[i] <= 0) {
                max = plus >= max ? plus : max;
                plus = 1;
                continue;
            } else {
                plus *= nums[i];
            }
        }

        return max;

    }
}
