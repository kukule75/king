package array;

import sun.security.util.Length;

/**
 * @author kinden
 *
 * 假设你是一个选择性遗忘的赌徒，数组表示你这几天来赢钱或者输钱，
 * 你用sum来表示这几天来的输赢，
 * 用ans来存储你手里赢到的最多的钱，
 *
 * 如果昨天你手上还是输钱（sum < 0），你忘记它，明天继续赌钱；
 * 如果你手上是赢钱(sum > 0), 你记得，你继续赌钱；
 * 你记得你手气最好的时候
 *
 */
public class MaxSubArray53 {

    public static void main(String[] args) {

        int nums[] = {-2,1,-3,4,-1,2,1,-5,4};

        System.out.println(maxSubArray(nums));
        System.out.println(maxSubArrayA(nums));
        System.out.println(maxSubArrayB(nums));
//        System.out.println(maxSubArrayC(nums));
        System.out.println(maxSubArrayD(nums));
    }

    // 0.贪心算法
    public static int maxSubArray(int[] nums) {

        int n = nums.length;
        int currSum = nums[0], maxSum = nums[0];

        for(int i = 1; i < n; ++i) {
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
    // 1.也是贪心算法的变形写法，实际与0一致
    public static int maxSubArrayA(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for(int num: nums) {
            if(sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }

    public static int maxSubArrayB(int[] nums) {

        int len = nums.length;
        int curSum = nums[0];
        int max = nums[0];

        for (int i = 1; i < len; i++) {
            if (curSum < 0) {
                curSum = nums[i];
            } else {
                curSum += nums[i];
            }
            max = Math.max(max, curSum);
        }

        return max;
    }

    // 动态规划，但是改变了原数组的值，这种写法不是最佳
    public static int maxSubArrayC(int[] nums) {
        int n = nums.length, maxSum = nums[0];

        for(int i = 1; i < n; ++i) {
            if (nums[i - 1] > 0) nums[i] += nums[i - 1];
            maxSum = Math.max(nums[i], maxSum);
        }

        return maxSum;
    }

    // 动态规划，使用辅助数组
    public static int maxSubArrayD(int[] nums) {

        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        int max = dp[0];
        for(int i = 1; i < nums.length; ++i) {
            dp[i] = (dp[i-1] >= 0) ? dp[i-1]+nums[i] : nums[i];

            max = Math.max(dp[i], max);
        }

        return max;
    }

}
