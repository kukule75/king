import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author kinden
 *
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 *
 * 输入: [1,2,3]
 */
public class Permute46 {


    public static void main(String[] args) {

        int[] nums = {1};

        List<List<Integer>> res = permute(nums);

        System.out.println(res.size());
    }

    public static List<List<Integer>> permute(int[] nums) {

        LinkedList<Integer> list = new LinkedList<>();

        List<List<Integer>> res = new LinkedList<>();

        backtrack(nums, list, res);

        return res;

    }

    static void backtrack(int[] nums, LinkedList<Integer> track, List<List<Integer>> res) {

        // 触发结束条件
        if (track.size() == nums.length) {
            res.add(new LinkedList(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 排除不合法的选择
            if (track.contains(nums[i]))
                continue;
            // 做选择
            track.add(nums[i]);
            // 进入下一层决策树
            backtrack(nums, track, res);
            // 取消选择
            track.removeLast();
        }

    }
}
