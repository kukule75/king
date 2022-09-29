package dynamic;

// 72
public class MinDistance {

    public static void main(String[] args) {

        String a = "horse";
        String b = "ros";

        System.out.println(minDistanceIteration(a, b));

    }

    public static int minDistance(String word1, String word2) {
        return dp(word1.length() - 1, word2.length() - 1, word1, word2);
    }

    // dp(i,j) 代表a[0...i] b[0...j]的最小编辑距离
    public static int dp(int i, int j, String word1, String word2) {
        if (i < 0) {
            return j + 1;
        }

        if (j < 0) {
            return i + 1;
        }

        if (word1.charAt(i) == word2.charAt(j)) {
            return dp(i - 1, j - 1, word1, word2);
        }

        int dpDelte = dp(i - 1, j, word1, word2);// 删除
        int dpInsert = dp(i, j - 1, word1, word2);// 插入
        int dpReplace = dp(i - 1, j - 1, word1, word2);// 替换

        return Math.min(Math.min(dpDelte, dpInsert), dpReplace) + 1;
    }

    // 0 1 3 4 5 6 7 8 9
    // 1
    // 2
    // 3
    // 4
    // 5
    // 6               op(6,9) = ?
    public static int minDistanceIteration(String word1, String word2) {

        int m = word1.length();
        int n = word2.length();

        //op[i][j] 代表word1[0...i-1]与word2[0...j-1]的编辑距离
        int[][] op = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            op[i][0] = i;
        }

        for (int i = 0; i <=n; i++) {
            op[0][i] = i;
        }

        for (int i = 1; i <=m; i++) {
            for (int j = 1; j <=n; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    op[i][j] = op[i-1][j-1];
                } else {
                    op[i][j] = Math.min(Math.min(op[i-1][j-1], op[i-1][j]), op[i][j-1]) + 1;
                }
            }
        }

        return op[m][n];
    }
}
