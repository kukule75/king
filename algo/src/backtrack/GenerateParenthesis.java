package backtrack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateParenthesis {

    public static void main(String[] args) {

        List<String> res = generateParenthesis(3);
        res.stream().forEach(a -> System.out.println(a));
    }

    public static List<String> generateParenthesis(int n) {

        String[] fass = {"(", ")"};
        ArrayList<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean sign = true;
        int left = 0;
        int right = 0;
        backtrack(fass, res, sb, n, left, right);


        return res;
    }

    public static void backtrack(String[] fass, ArrayList<String> res, StringBuilder cur, int n, int left, int right) {

        if (cur.length() == 2 * n) {
            res.add(cur.toString());
            return;
        }

        if (left < n) {
            cur.append('(');
            backtrack(fass, res, cur, n, left+1, right);
            cur.deleteCharAt(cur.length() - 1);
        }

        if (left > right) {
            cur.append(')');
            backtrack(fass, res, cur, n, left, right+1);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
