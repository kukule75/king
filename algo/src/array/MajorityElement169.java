package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author kinden
 *
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 这是一个重要的假设，有了这个假设
 * 1.才可以使用投票算法：你可以假设数组是非空的，并且给定的数组总是存在众数。复杂度为O(n)
 *  此题没有办法是用分治，但是可以缩小规模，如果m != n，可以同时去掉m和n，不会影响结果。
 * 2.如果众数一定存在，那么这些数字排序后，中间的那个数一定是众数,复杂度为O(nlgn)
 * 3.排序可以使用快速排序，但是没有必要全排序，我们只需要知道中间那个数
 * 4.再细想，遍历一遍都闲多，这是概率问题，
 *
 * 分析：众数一定出现偶次数
 *
 * 输入: [3,2,3]
 * 输出: 3
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 */
public class MajorityElement169 {

    public static void main(String[] args) {

//        int[] nums = {2,2,1,1,1,3,2,2};

        int[] nums = {6,6,8,7,9};

        System.out.println(majorityElement(nums));
        System.out.println(majorityElementA(nums));


    }

    // 1.hash法
    public static int majorityElementA(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        int max = Integer.MIN_VALUE;
        int res = nums[0];

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int e = map.get(nums[i])+1;
                map.put(nums[i], e);
                if (e > max) {
                    max = e;
                    res = nums[i];
                }
            } else {
                map.put(nums[i], 1);
            }
        }

        return res;
    }

    // 0.投票法，有个重要前提，就是一定存在众数
    public static int majorityElement(int[] nums) {

        int candidate = nums[0];
        int mark = 0;

        for (int e : nums) {
            if (mark == 0) {
                candidate = e;
            }
            if (e == candidate){
                mark++;
            } else {
                mark--;
            }
        }

        return candidate;
    }
}
