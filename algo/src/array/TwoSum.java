package array;

import java.util.Arrays;

/**
 * @author kinden
 *
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 *
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 *
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 */
public class TwoSum {

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,6,7};

        int[] res = twoSum(arr, 13);

        Arrays.stream(res).forEach(System.out::println);
    }

    private static int[] twoSum(int[] arr, int target) {

        int len = arr.length;
        int[] res = new int[2];

        for (int i = 0, j = len - 1; i < j;) {
            int sum = arr[i] + arr[j];
            if (sum < target) {
                i++;
            } else if (sum > target){
                j--;
            } else {
                res[0] = i + 1;
                res[1] = j + 1;
                return res;
            }
        }

        return res;
    }

    private static int[] twoSumA(int[] arr, int target) {

        int len = arr.length;
        int[] res = new int[2];

        int i = 0, j = len - 1;
        while (i < j){
            int sum = arr[i] + arr[j];
            if (sum < target) {
                i++;
            } else if (sum > target){
                j--;
            } else {
                res[0] = i + 1;
                res[1] = j + 1;
                return res;
            }
        }

        return res;
    }
}
