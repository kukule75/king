package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，
 * 找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 *
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 *
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 */
public class CombinationSum {

    public static void main(String[] args) {

        int[] candidates = {2,3,6,7};
        List<List<Integer>> res = combinationSum(candidates, 7);

        res.stream().forEach(a -> System.out.println(Arrays.toString(a.toArray())));

    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> track = new LinkedList<>();
        int trackSum = 0;
        Arrays.sort(candidates);
        backtrack(candidates, target, trackSum, track, res);

        return res;
    }

    public static void backtrack(int[] candidates, int target, int trackSum, LinkedList<Integer> track, List<List<Integer>> res) {

        if (trackSum > target) {
            return;
        }

        if (trackSum == target) {
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i = 0; i < candidates.length; i++) {
            track.addLast(candidates[i]);
            trackSum += candidates[i];
            backtrack(candidates, target, trackSum, track, res);
            track.removeLast();
            trackSum -= candidates[i];
        }

    }
}
