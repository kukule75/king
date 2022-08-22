package binarySearch;

import java.util.Arrays;

/**
 * @author kinden
 * <p>
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 */
public class SearchRange {

    public static void main(String[] args) {

//        int[] nums = {5,7,7,8,8,10};
        int[] nums = {1, 1, 2};
        int[] res = searchRange(nums, 1);


        Arrays.stream(res).forEach(System.out::println);
    }

    // num[mid] target
    // target nums[mid]
    private static int[] searchRange(int[] nums, int target) {

        int i = 0;
        int j = nums.length - 1;
        int min = -1;
        int max = -1;

        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] == target) {
                min = mid;
                max = mid;
            } else if (nums[mid] > target) {
                j = mid - 1;
                max = j;
            } else if (nums[mid] < target) {
                i = mid + 1;
                min = i;
            }
        }

        return nums;
    }


}
