package math;

/**
 * @author kinden
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 *
 * 说明:
 * 你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?
 *
 * 输入: [3,0,1]
 * 输出: 2
 *
 * 输入: [9,6,4,2,3,5,7,0,1]
 * 输出: 8
 */
public class MissingNumber {

    public static void main(String[] args) {

        int[] nums = {9,6,4,2,3,5,7,0,1};


        System.out.println(missingNumberA(nums));
    }

    //异或运算，因为两个相同的数异或值=0，0与n的异或值为n
    public static int missingNumberA(int[] nums) {

        int miss = nums.length;

        for (int i = 0; i < nums.length; i++) {
            miss ^= i ^ nums[i];
        }

        return miss;

    }

    //数学公式
    public static int missingNumber(int[] nums) {

        int len = nums.length;
        int total = (len * (len + 1)) >> 1;

        for (int i = 0; i < len; i++) {
            total -= nums[i];
        }

        return total;

    }
}
