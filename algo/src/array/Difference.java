package array;

import java.util.Arrays;

// 差分数组
public class Difference {

    public static void main(String[] args) {

        int[] nums = {8, 5, 9, 6, 1};
        Difference difference = new Difference(nums);
        difference.increment(2, 3 , 3);

        System.out.println(Arrays.toString(difference.result()));
    }

    private int[] diff;

    // 8  5 9  6  1
    // 8 -3 4 -3 -5
    public Difference(int[] nums) {

        diff = new int[nums.length];
        diff[0] = nums[0];
        for (int i = 1; i < diff.length; i++) {
            diff[i] = nums[i] - nums[i - 1];
        }
    }

    /* 给闭区间 [i, j] 增加 val（可以是负数）*/
    public void increment(int i, int j, int val) {
        diff[i] += val;
        if (j + 1 < diff.length) {
            diff[j + 1] -= val;
        }
    }

    public int[] result() {

        int[] res = new int[diff.length];

        res[0] = diff[0];
        for (int i = 1; i < res.length; i++) {
            res[i] = diff[i] + res[i - 1];
        }

        return res;
    }
}
