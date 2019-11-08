package array;

import java.util.Arrays;

/**
 * @author kinden
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 */
public class MoveZeroes {

    public static void main(String[] args) {

        int[] nums = {0,1,0,3,12};
//        int[] nums = {1,0,1,0};
//        int[] nums = {0,1,1,0,3,12};

        moveZeroes(nums);

        Arrays.stream(nums).forEach(System.out::println);
    }

    public static void moveZeroes(int[] nums) {

        int len = nums.length;

        int j = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] !=  0 ) {
                nums[j++] = nums[i];
            }
        }

        for(int i = j; i < len; i++) {
            nums[i] = 0;
        }
    }

    public static void moveZeroesA(int[] nums) {

        int len = nums.length;

        int i = 0;
        int j = 0;
        while (i < len && j < len) {
            while (i < len && nums[i] != 0) {
                i++;
            }
            if (i == len) {
                return;
            }
            j = j > i ? j : i + 1;
            while (j < len && nums[j] == 0) {
                j++;
            }
            if (j == len) {
                return;
            }

            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
    }
}
