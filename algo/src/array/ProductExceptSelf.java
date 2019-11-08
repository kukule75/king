package array;

import sun.security.util.Length;

import java.util.Arrays;

/**
 * @author kinden
 * 给定长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * 进阶：
 * 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 *
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 */
public class ProductExceptSelf {

    public static void main(String[] args) {

        int[] nums = {1,2,3,4};
        int[] res = productExceptSelf(nums);

        Arrays.stream(res).forEach(System.out::println);
    }

    public static int[] productExceptSelf(int[] nums) {

        int len = nums.length;
        int[] res = new int[len];

        int k = 1;
        for (int i = 0; i < len; i++) {
            res[i] = k;
            k *= nums[i];
        }

        k = 1;
        for (int i = len - 1; i >= 0; i--) {
            res[i] *= k;
            k *= nums[i];
        }

        return res;
    }
}
