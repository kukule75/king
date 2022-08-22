package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {

    public static void main(String[] args) {

        List<List<String>> res = solveNQueens(4);

        res.stream().forEach(a -> System.out.println(Arrays.toString(a.toArray())));
    }

    public static List<List<String>> solveNQueens(int n) {

        List<List<String>> res = new ArrayList<>(n);
        backtrack(n, res);

        return res;
    }

    public static void backtrack(int n, List<List<String>> res) {

        for (int i = 0; i < n; i++) {
            List<String> cur = res.get(i);
            cur.add(i, "Q");
//            backtrack();
        }
    }
}
