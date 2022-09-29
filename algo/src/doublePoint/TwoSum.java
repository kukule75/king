package doublePoint;

import java.util.Arrays;

public class TwoSum {

    public static void main(String[] args) {

        int[] numbers = {2,7,11,15};
        int[] res = twoSum(numbers, 18);

        System.out.println(Arrays.toString(res));
    }

    public static int[] twoSum(int[] numbers, int target) {

        int i = 0;
        int j = numbers.length - 1;

        int sum;
        while (i <= j) {
            sum = numbers[i] + numbers[j];
            if (sum == target) {
                return new int[]{i, j};
            } else if (sum < target) {
                i++;
            } else if (sum > target) {
                j--;
            }
        }

        return new int[]{-1, -1};
    }
}
