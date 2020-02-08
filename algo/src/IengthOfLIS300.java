import javax.swing.*;
import java.util.Arrays;

/**
 * @author kinden
 */
public class IengthOfLIS300 {

    public static void main(String[] args) {

//        int[] nums = {10,9,2,5,3,7,101,18};
        int[] nums = {3,5,6,2,5,4,19,5,6,7,12};

//        System.out.println(lengthOfLIS(nums));
//        System.out.println(lengthOfLISA(nums));
        System.out.println(lengthOfLISB(nums));
    }

    // 0.暴力递归不带缓存，T(n)=2T(n-1)，O(2^n)
    public static int lengthOfLISA(int[] nums) {
        return lengthOfLISRecurse(nums, 0, Integer.MIN_VALUE);
    }

    // 比pre大的最长子序列
    private static int lengthOfLISRecurse(int[] nums, int curpos, int pre) {

        if (curpos == nums.length) {
//            System.out.println("[curpos = "+ curpos + ", pre = " + pre + "] = 0");
            return 0;
        }
//        System.out.println("[curpos = "+ curpos + ", pre = " + pre + "]");
        int taken = 0;
        if (nums[curpos] > pre) {
            taken = 1 + lengthOfLISRecurse(nums, curpos + 1, nums[curpos]);
        }
        int nottaken = lengthOfLISRecurse(nums, curpos + 1, pre);
        return Math.max(taken, nottaken);
    }

    // 1.暴力递归带缓存
    public static int lengthOfLIS(int[] nums) {


        int[][] men = new int[nums.length][nums.length+1];
        return lengthOfLISRecurseMen(nums, 0, -1, men);
    }

    // 带缓存的递归，可以把复杂度降为O(n^2)
    private static int lengthOfLISRecurseMen(int[] nums, int curpos, int prepos, int[][] men) {

        if (curpos == nums.length) {
            return 0;
        }

        if (men[curpos][prepos+1] != 0) {
            System.out.println("hit cache, [curpos = "+ curpos + ", prepos = " + (prepos+1) + "] = " + men[curpos][prepos+1]);
            return men[curpos][prepos+1];
        } else {
            System.out.println("no cache, [curpos = "+ curpos + ", prepos = " + (prepos+1) + "]");
        }

        int pre = (prepos == -1) ? Integer.MIN_VALUE : nums[prepos];

        int taken = 0;
        if (nums[curpos] > pre) {
            taken = 1 + lengthOfLISRecurseMen(nums, curpos + 1, curpos, men);
        }
        int nottaken = lengthOfLISRecurseMen(nums, curpos + 1, prepos, men);

        int res = Math.max(taken, nottaken);
        men[curpos][prepos+1] = res;
        System.out.println("set men,[curpos = "+ curpos + ", prepos = " + (prepos+1) + "] = " + res);

        return res;
    }

    // 3.动态规划
    // 傻瓜版图解，https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/man-hua-ti-jie-zai-ben-du-neng-kan-de-dong-de-dong/
    public static int lengthOfLISB(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        int res = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            res = Math.max(res, dp[i]);
        }

        return res;
    }

    // 二分法
    // https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/dong-tai-gui-hua-she-ji-fang-fa-zhi-pai-you-xi-jia/
    public static int lengthOfLISC(int[] nums){

        // TODO

        return 1;
    }


}
