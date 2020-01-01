package array;

import java.util.*;

/**
 * @author kinden
 *
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 */
public class ThreeSum {

    public static void main(String[] args) {


//        int[] nums = {-1, 0, 1, 2, -1, -4};

        int[] nums = {0,0,0};
        List<List<Integer>> res = threeSumB(nums);

        System.out.println(res.size());
    }

    // 最笨的方法，复杂度O(n^3)，输出下标，也就是不用判断元素的重复
    public static List<List<Integer>> threeSum(int[] nums) {

        int len = nums.length;

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                for (int k = j+1; k < len; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(i);
                        list.add(j);
                        list.add(k);
                        res.add(list);
                    }
                }
            }
        }

        return res;
    }

    // 排序，数组两边夹逼
    public static List<List<Integer>> threeSumB(int[] nums) {

        int len = nums.length;

        List<List<Integer>> res = new ArrayList<>();

        //[-4, -1, -1, 0, 1, 2]
        Arrays.sort(nums);

        for (int i = 0; i < len - 1; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = len - 1;

            while (j < k) {
                int sum =  nums[j] + nums[k] + nums[i];
                if (sum > 0) {
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (j + 1 < k && nums[j + 1] == nums[j]) {
                        j++;
                    }
                    j++;
                    while (j < k - 1 && nums[k - 1] == nums[k]) {
                        k--;
                    }
                    k--;
                }
            }
        }

        return res;
    }

    // 未完成，排重不好处理
    public static List<List<Integer>> threeSumA(int[] nums) {

        int len = nums.length;

        List<List<Integer>> res = new ArrayList<>();
        Set<Integer> r = new HashSet<>(len);

        //[-4, -1, -1, 0, 1, 2]
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            r.add(nums[i]);
        }

        for (int i = 0; i < len; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int k = i + 1; k < len; k++) {
                int e = 0 - nums[i] - nums[k];
                if (r.contains(e) && e > nums[k]) {
                    res.add(Arrays.asList(nums[i], nums[k], e));
                }
            }
        }

        return res;

    }
}
