package binarySearch;

/**
 * @author YuXiaodan
 * @ClassName binarySearch.BinarySearch
 * @Description
 * @date 2019年09月10日 2019/9/10
 */
public class BinarySearch {

    public static void main(String[] args) {

//		int[] array = {1,2,3,23,26,33,37,45,49,51,56,60,64,72,78,83,88,97,100};
        int[] array = {1, 2, 2, 2, 3};
//		System.out.println(binarySearch(array, 34));
//        System.out.println(search(array, 2));
        System.out.println(searchRight(array, 2));
    }


    // 基础版本
    // 存在的问题：nums = [1,2,2,2,3]，target 为 2，此算法返回的索引是 2，无法找到最左元素
    private static int search(int[] nums, int target) {

        int i = 0;
        int j = nums.length - 1;

        while (i <= j) {// 为什么<=
            int mid = i + (j - i) / 2;
            int cur = nums[mid];
            if (cur > target) {
                j = mid - 1; // 为什么-1
            } else if (cur < target) {
                i = mid + 1; // 为什么+1
            } else {
                return mid;
            }
        }

        return -1;
    }

    // 匹配最左元素
    private static int searchLeft(int[] nums, int target) {

        int i = 0;
        int j = nums.length;

        while (i < j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] == target) {
                j = mid;
            } else if (nums[mid] > target) {
                j = mid;
            } else if (nums[mid] < target) {
                i = mid + 1;
            }
        }

        // target比所有数都大
        if (j == nums.length) {
            return -1;
        }
        return nums[i] == target ? i : -1;
    }

    private static int searchRight(int[] nums, int target) {

        int i = 0;
        int j = nums.length;

        while (i < j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] == target) {
                i = mid + 1;
            } else if (nums[mid] < target) {
                i = mid + 1;
            } else if (nums[mid] > target) {
                j = mid;
            }
        }

        if (i - 1 < 0) {
            return -1;
        }

        return nums[i - 1] == target ? i - 1: -1;/**/
    }
}
