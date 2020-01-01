package binarySearch;

import java.util.Arrays;

/**
 * @author kinden
 *
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 */
public class SearchRange {

    public static void main(String[] args) {

//        int[] nums = {5,7,7,8,8,10};
        int[] nums = {1,1,2};
        int[] res = searchRange(nums, 1);


        Arrays.stream(res).forEach(System.out::println);
    }

    //可能退化成O(n)
    public static int[] searchRange(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;
        int[] res = {-1, -1};

        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                int i = mid + 1;
                for (; i <= high && nums[i] == target; i++) {
                }
                res[1] = i - 1;
                int j = mid - 1;
                for (; j >= 0 && nums[j] == target; j--) {
                }
                res[0] = j + 1;

                return res;
            }
        }

        return res;
    }
}
