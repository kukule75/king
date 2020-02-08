package array;

import java.util.Arrays;

/**
 * @author kinden
 *
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * nums = [9]，输出nums = [1,0]
 */
public class PlusOne {

    public static void main(String[] args) {

        int[] nums = {8,9,9,9};

        int[] res = plusOne(nums);

        Arrays.stream(res).forEach(System.out::print);

    }

    private static int[] plusOne(int[] nums) {

        int carry = 0;
        nums[nums.length - 1] = nums[nums.length - 1] + 1;
        int temp;
        for (int i = nums.length - 1; i >= 0; i--) {
            temp = nums[i] + carry;
            if (temp > 9) {
                nums[i] = temp - 10;
                carry = 1;
            } else {
                nums[i] = temp;
                carry = 0;
                break;
            }
        }

        if (carry == 1) {
            int[] res = new int[nums.length+1];
            res[0] = 1;
            System.arraycopy(nums, 0, res, 1, nums.length);
            return res;
        }

        return nums;
    }
}
