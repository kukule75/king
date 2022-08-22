package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SubsetsWithDup {

    public static void main(String[] args) {

        int[] nums = {1,2,2};

        List<List<Integer>> res = subsetsWithDup(nums);
        res.stream().forEach(a -> System.out.println(Arrays.toString(a.toArray())));
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> track = new LinkedList<>();

        Arrays.sort(nums);

        backtrack(nums, 0, track, res);

        return res;
    }

    public static void backtrack(int[] nums, int start, LinkedList<Integer> track, List<List<Integer>> res) {

        res.add(new LinkedList<>(track));

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i-1]) {
                continue;
            }
            track.add(nums[i]);
            backtrack(nums, i+1, track, res);
            track.removeLast();
        }
    }
}
