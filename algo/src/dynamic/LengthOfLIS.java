package dynamic;

import java.util.Arrays;

public class LengthOfLIS {

    public static void main(String[] args) {

        int[] nums = {10,9,2,5,3,7,101,18};
        int i = what(nums);
        System.out.println(i);
    }

    /**
     * 带备忘录的动态规划
     * dp[i]的定义：以int[i]结尾的最长递增子序列长度
     *
     * @param nums
     * @return
     */
    private static int what(int[] nums) {

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        int res = -1;

        for (int i = 1; i < nums.length; i++) {
            int cur = -1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    cur = Math.max(cur, dp[j] + 1);
                }
            }
            if (cur != -1) {
                dp[i] = cur;
                res = Math.max(res, dp[i]);
            }
        }

        return res;
    }

    private static int whatOption(int[] nums) {

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        int res = -1;

        for (int i = 1; i < nums.length; i++) {
            int cur = -1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    cur = Math.max(cur, dp[j] + 1);
                }
            }
            if (cur != -1) {
                dp[i] = cur;
                res = Math.max(res, dp[i]);
            }
        }

        return res;
    }
}
