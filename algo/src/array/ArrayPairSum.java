package array;

import java.util.Arrays;

/**
 * @author kinden
 *
 * 给定长度为 2n 的数组, 你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从1 到 n 的 min(ai, bi) 总和最大。
 *
 * 输入: [1,4,3,2]
 *
 * 输出: 4
 * 解释: n 等于 2, 最大总和为 4 = min(1, 2) + min(3, 4).
 *
 * 其实问题就是对数组排序，间隔元素相加就行
 */
public class ArrayPairSum {

    public static void main(String[] args) {

        int[] arr = {1,9,7,4};

        System.out.println(arrayPairSum(arr));

    }

    private static int arrayPairSum(int[] arr) {

        Arrays.sort(arr);

        int sum = 0;
        for (int i = 0; i < arr.length; i += 2) {
            sum += arr[i];
        }

        return sum;
    }
}
