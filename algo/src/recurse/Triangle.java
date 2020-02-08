package recurse;

import java.util.LinkedList;
import java.util.List;

/**
 * @author kinden
 */
public class Triangle {

    public static void main(String[] args) {

        generate(5);
    }

    // 递归
    public static List<List<Integer>> generate(int numRows) {

        List<List<Integer>> res = new LinkedList<>();

        helper(1, numRows, res);

        return res;
    }

    private static void helper(int start, int numRows, List<List<Integer>> res){

        if (start > numRows) {
            return;
        }

        List<Integer> e = new LinkedList<>();
        for (int i = 0; i < start; i++) {
            if (i == 0 || i == start - 1) {
                e.add(1);
                continue;
            }
            List<Integer> list = res.get(start-2);
            e.add(list.get(i-1) + list.get(i));
        }

        res.add(e);

        helper(start+1, numRows, res);
    }
}
