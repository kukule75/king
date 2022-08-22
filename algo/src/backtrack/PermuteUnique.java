package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PermuteUnique {

    public static void main(String[] args) {

        int[] nums = {1,1,2};

        List<List<Integer>> lists = permuteUnique(nums);

        lists.stream().forEach(a -> System.out.println(Arrays.toString(a.toArray())));
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> track = new LinkedList<>();

        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];

        backtrack(nums, track, res, used);

        return res;
    }

    public static void backtrack(int[] nums, LinkedList<Integer> track, List<List<Integer>> res, boolean[] used) {

        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            track.add(nums[i]);
            used[i] = true;
            backtrack(nums, track, res, used);
            track.removeLast();
            used[i] = false;
        }
    }
}
