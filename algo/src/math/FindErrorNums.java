package math;

import java.util.Arrays;

public class FindErrorNums {

    public static void main(String[] args) {

        int[] nums = {1,2,2,4};

        int[] res = findErrorNums(nums);

        System.out.println(Arrays.toString(res));


    }

    public static int[] findErrorNums(int[] nums) {

        int[] res = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int cur = Math.abs(nums[i]) - 1;
            if (nums[cur] < 0) {
                res[0] = Math.abs(nums[i]);
            } else {
                nums[cur] = -nums[cur];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res[1] = i + 1;
            }
        }

        return res;
    }

    // 4 ^ 0 ^ 1 ^ 1 ^ 2 ^ 3 ^ 4
    // 4 ^ 0 ^ 1 ^ 1 ^ 2 ^ 2 ^ 2 ^ 3 ^ 4
}
