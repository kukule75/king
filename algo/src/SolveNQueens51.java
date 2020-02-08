import java.util.List;

/**
 * @author kinden
 *
 * https://leetcode-cn.com/problems/n-queens/
 *
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 * 输入: 4
 * 输出: [
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 *
 */
public class SolveNQueens51 {

    public static void main(String[] args) {

        List<List<String>> res = solveNQueens(4);

        System.out.println(res.size());
    }

    public static List<List<String>> solveNQueens(int n) {

        return null;
    }
}
