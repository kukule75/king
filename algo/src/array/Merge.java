package array;

import java.util.Arrays;

/**
 * @author kinden
 *
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 */
public class Merge {

    public static void main(String[] args) {

        int[] nums1 = {1,3,5,0,0,0,0};
        int[] nums2 = {4,5,6,7};

        merge(nums1, nums1.length, nums2, nums2.length);

        Arrays.stream(nums1).forEach(System.out::println);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int len2 = nums2.length;//i
        int len1 = nums1.length;//j > i
        int k = len1 - 1;
        for (int i = len2 - 1, j = len1 - len2 - 1; i >= 0 || j >= 0;) {
            if (i < 0) {
                nums1[k--] = nums1[j--];
            } else if (j < 0){
                nums1[k--] = nums2[i--];
            } else {
                nums1[k--] = nums1[j] >= nums2[i] ? nums1[j--] : nums2[i--];
            }
        }

    }
}
