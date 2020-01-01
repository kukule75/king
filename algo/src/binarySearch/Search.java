package binarySearch;

/**
 * @author kinden
 *
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，
 * 写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 *
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 *
 * 提示：
 * 你可以假设 nums 中的所有元素是不重复的。
 * n 将在 [1, 10000]之间。
 * nums 的每个元素都将在 [-9999, 9999]之间。
 *
 * 边界问题可以参考下面文章
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/solution/er-fen-cha-zhao-suan-fa-xi-jie-xiang-jie-by-labula/
 */
public class Search {

    public static void main(String[] args) {

//        int[] nums = {-1,0,3,5,9,12};

        int[] nums = {1,1,2,2,2,2,2,2};
        System.out.println(leftSearchB(nums, 2));
    }

    //总体思路是，把等于当前大于，缩小左边范围继续寻找
    public static int leftSearchB(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target){
                low = mid + 1;
            } else {
                if (mid == 0 || nums[mid - 1] != target) {
                    return mid;
                }
                high = mid - 1;
            }
        }

        return -1;
    }

    //总体思路是，把等于当前大于，缩小左边范围继续寻找，合并了代码，简洁但是烧脑
    public static int leftSearchA(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] >= target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        if (low < nums.length && nums[low] == target) {
            return low;
        }
        return -1;
    }

    //左边边界查找，low所代表的意义是数组中小于target的元素有low个
    public static int leftSearch(int[] nums, int target) {

        int low = 0;
        int high = nums.length;

        while (low < high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] > target) {
                high = mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    //右边界查找
    public static int rightSearch(int[] nums, int target) {

        int low = 0;
        int high = nums.length;

        while (low < high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] > target) {
                high = mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                low = mid + 1;
            }
        }

        return high - 1;
    }

    //标准的查找框架，查找具体某个值是否存在有优势
    public static int search(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;

        // =号是必须的，1.需要考虑只有一个元素的数组；2.当low、high指向同个元素的时候
        while (low <= high) {
            // 特使需要注意不要写成low + (high - low) >> 1，运算符优先级问题
            int mid = low + ((high - low) >> 1);
            if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else  {
                return mid;
            }
        }

        return -1;
    }
}
