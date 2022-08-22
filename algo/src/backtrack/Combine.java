package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Combine {

    public static void main(String[] args) {

        List<List<Integer>> res = combine(4, 2);

        res.stream().forEach(a -> System.out.println(Arrays.toString(a.toArray())));
    }

    public static List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> res = new ArrayList<>();

        LinkedList<Integer> track = new LinkedList<>();
        backtrack(n, k, 1, track, res);

        return res;
    }

    public static void backtrack(int n, int k, int start, LinkedList<Integer> track, List<List<Integer>> res) {

        if (track.size() == k) {
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i = start; i <= n; i++) {
            track.addLast(i);
            backtrack(n, k, i+1, track, res);
            track.removeLast();
        }
    }
}
