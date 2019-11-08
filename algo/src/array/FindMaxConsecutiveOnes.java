package array;

/**
 * @author kinden
 *
 * 给定一个二进制数组， 计算其中最大连续1的个数。
 *
 * 输入: [1,1,0,1,1,1]
 * 输出: 3
 * 解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
 */
public class FindMaxConsecutiveOnes {

    public static void main(String[] args) {

        int[] nums = {1,1,0,1,1,1};

        int res = findMaxConsecutiveOnes(nums);

        System.out.println(res);
    }

    public static int findMaxConsecutiveOnes(int[] nums) {

        int len = nums.length;

        int max = 0;
        int temp = 0;
        int k = 0;
        while (k < len) {
            if (nums[k++] == 1) {
                temp++;
            } else {
                max = max >= temp ? max : temp;
                temp = 0;
            }
        }

        return max >= temp ? max : temp;
    }
}
