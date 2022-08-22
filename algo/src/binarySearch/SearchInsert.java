package binarySearch;

/**
 * 变体：
 * 1、统计有序无重数组中小于target的元素个数，需要使用logN的复杂度
 * 2、搜索有序无重的数组中大于等于target的最小元素
 */
public class SearchInsert {

    public static void main(String[] args) {

        int[] nums = {1, 3, 5, 6};
        System.out.println(searchInsert(nums, 0));
    }

    public static int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            }
        }

        return low > high ? low : high;
    }
}
