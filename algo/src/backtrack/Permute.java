package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Permute {

    private static List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {

        int[] nums = {0,1,2};

        List<List<Integer>> permute = permute(nums);

        permute.stream().forEach(a -> System.out.println(Arrays.toString(a.toArray())));

    }

    private static List<List<Integer>> permute(int[] nums) {

        LinkedList<Integer> track = new LinkedList<>();

        boolean[] used = new boolean[nums.length];

        backtrack(nums, track, used);

        return res;

    }

    private static void backtrack(int[] nums, LinkedList<Integer> track, boolean[] used) {

        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (used[i] == true) {
                continue;
            }

            track.add(nums[i]);
            used[i] = true;
            backtrack(nums, track, used);
            track.removeLast();
            used[i] = false;
        }
    }
}
