package binarySearch;

import java.util.Arrays;

/**
 * @author kinden
 *
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 元素可以重复
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 *
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 */
public class FindKthLargest {

    public static void main(String[] args) {

//        int[] array = {1,2,3,23,26,33,37,45,49,51,56,60,64,72,78,83,88,97,100};

//        int[] array = {-1,0,3,5,9,12};

//        int[] array = {5};

//        System.out.println(binarySearch(array, 33));

        int[] array = {3,2,3,1,2,4,5,5,6};

        System.out.println(findKthLargestA(array, 4));
    }

    //排序
    public static int findKthLargestA(int[] nums, int k) {

        int len = nums.length;
        Arrays.sort(nums);
        return nums[len - k];

    }

    //快排思路递归写法
    public static int findKthLargest(int[] nums, int k) {

        return quickSearch(nums, 0, nums.length - 1, nums.length - k);
    }

    //利用快排思路，O(n)
    public static int quickSearch(int[] a, int start, int end, int k) {

        int i = start;
        int j = end;
        int pivot = a[end];

        while (i < j) {
            while (i < j && a[i] <= pivot) {
                i++;
            }
            while (i < j && a[j] >= pivot) {
                j--;
            }

            if (i != j) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }

        a[end] = a[i];
        a[i] = pivot;

        if (i < k) {
            return quickSearch(a, i + 1, end, k);
        } else if (i > k) {
            return quickSearch(a, start, i - 1, k);
        } else {
            return a[i];
        }

    }
}
