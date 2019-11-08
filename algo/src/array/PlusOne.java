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

        int[] nums = {1,2,3};
    }

    private static int[] plusOne(int[] nums) {

        int temp = nums[nums.length - 1];
        nums[nums.length - 1] = temp + 1;

        return nums;
    }
}
