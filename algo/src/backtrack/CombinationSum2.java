package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 元素可重不可复选
 */
public class CombinationSum2 {
    public static void main(String[] args) {

        int[] candidates = {10,1,2,7,6,1,5};

        List<List<Integer>> res = combinationSum(candidates, 8);

        res.stream().forEach(a -> System.out.println(Arrays.toString(a.toArray())));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> track = new LinkedList();

        Arrays.sort(candidates);

        int trackSum = 0;
        backtrack(candidates, target, 0, track, trackSum, res);

        return res;

    }

    public static void backtrack(int[] candidates, int target, int start, LinkedList<Integer> track, int trackSum, List<List<Integer>> res) {

        if (trackSum == target) {
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if ( i > start && candidates[i] == candidates[i-1]) {
                continue;
            }
            track.add(candidates[i]);
            trackSum += candidates[i];
            backtrack(candidates, target, i + 1, track, trackSum, res);
            track.removeLast();
            trackSum -= candidates[i];
        }
    }
}
