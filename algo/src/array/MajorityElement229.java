package array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author kinden
 *
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
 *
 * Note: The algorithm should run in linear time and in O(1) space.
 */
public class MajorityElement229 {

    public static void main(String[] args) {

        int[] nums = {1,1,1,3,3,2,2,2};

        List<Integer> res = majorityElement(nums);

        res.stream().forEach(System.out::print);

    }

    public static List<Integer> majorityElement(int[] nums) {

        int len = nums.length;
        if (len == 0) {
            return Arrays.asList();
        }

        int candidateA = nums[0];
        int candidateB = nums[0];

        int countA = 0;
        int countB = 0;


        for (int i = 0; i < len; i++) {

            if (nums[i] == candidateA) {
                countA++;
                continue;
            }
            if (nums[i] == candidateB) {
                countB++;
                continue;
            }

            if (countA == 0) {
                candidateA = nums[i];
                countA++;
                continue;
            }
            if (countB == 0) {
                candidateB = nums[i];
                countB++;
                continue;
            }

            countA--;
            countB--;
        }

        countA = 0;
        countB = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == candidateA) {
                countA++;
                continue;
            }
            if (nums[i] == candidateB) {
                countB++;
                continue;
            }
        }

        List<Integer> res = new LinkedList<>();
        int mark = len/3;
        if (countA > mark) {
            res.add(candidateA);
        }
        if (countB > mark) {
            res.add(candidateB);
        }

        return res;
    }
}
