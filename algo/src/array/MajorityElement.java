package array;

/**
 * @author kinden
 *
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 这是一个重要的假设，有了这个假设，才可以使用投票算法：你可以假设数组是非空的，并且给定的数组总是存在众数。
 *
 * 分析：众数一定出现偶次数
 *
 * 输入: [3,2,3]
 * 输出: 3
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 *
 * 1.暴力，遍历树元素，统计出现次数
 * 2.hash统计，空间复杂度O(N)，时间复杂度为O(N)
 * 3.排序，时间复杂度O(NlgN)，
 * 4.
 */
public class MajorityElement {

    public static void main(String[] args) {

        int[] nums = {2,2,2,1,1,1,3,2};

        System.out.println(majorityElement(nums));

    }

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
