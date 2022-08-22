package backtrack;

import java.util.*;

public class Subsets {

    public static void main(String[] args) {

        int[] nums = {4,1,0};

        List<List<Integer>> subsets = subsets(nums);

        subsets.stream().forEach(a -> System.out.println(Arrays.toString(a.toArray())));
//        List<List<Integer>> subsets = new ArrayList<>();
//        iterative(nums, subsets);

//        subsets.stream().forEach(a -> System.out.println(Arrays.toString(a.toArray())));
    }

    // iteration
    public static void iterative(int[] nums, List<List<Integer>> subsets) {

        subsets.add(new ArrayList<>());

        for (int i = 0; i < nums.length; i++) {
            int size = subsets.size();
            for (int j = 0; j < size; j++) {
                List<Integer> cur = new ArrayList<>(subsets.get(j));
                cur.add(nums[i]);
                subsets.add(cur);
            }
        }
    }

    // backtrack
    public static List<List<Integer>> subsets(int[] nums) {

        LinkedList<Integer> track = new LinkedList<>();

        boolean[] used = new boolean[nums.length];

        List<List<Integer>> res = new ArrayList<>();

        backtrack(nums, track, used, Integer.MIN_VALUE, res);

        return res;
    }

    private static void backtrack(int[] nums, LinkedList<Integer> track, boolean[] used, int sentinel, List<List<Integer>> res) {

        res.add(new LinkedList<>(track));

        for (int i = 0; i < nums.length; i++) {

            if (used[i] == true || nums[i] < sentinel) {
                continue;
            }

            track.add(nums[i]);
            used[i] = true;
            backtrack(nums, track, used, nums[i], res);
            track.removeLast();
            used[i] = false;
        }
    }
}
