package dynamic;

import java.util.Arrays;

public class MinFallingPathSum {

    public static void main(String[] args) {

        int[][] matrix = new int[3][3];
        matrix[0][0] = 2;
        matrix[0][1] = 1;
        matrix[0][2] = 3;
        matrix[1][0] = 6;
        matrix[1][1] = 5;
        matrix[1][2] = 4;
        matrix[2][0] = 7;
        matrix[2][1] = 8;
        matrix[2][2] = 9;

        int minFallingPathSum = minFallingPathSumOption(matrix);

        System.out.println(minFallingPathSum);
    }

//    public static int minFallingPathSum(int[][] matrix) {
//
//        int row = matrix.length;
//        int col = matrix[0].length;
//
//        int res;
//
//        for (int j = 0; j < col; j++) {
//            res = Math.min(res, minFallingPathSum);
//        }
//    }

    /**
     * dp[i][j]为matrix[i][j]的最大下降子序列
     *
     * @param matrix
     * @return
     */
    public static int minFallingPathSum(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        int[][] dp = new int[row][col];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, Integer.MAX_VALUE));

        for (int i = row - 1; i >= 0; i--) {
            for (int j = 0; j < col; j++) {
                if (i == row - 1) {
                    dp[i][j] = matrix[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i][j], matrix[i][j] + dp[i + 1][j]);
                    if (j - 1 >= 0) {
                        dp[i][j] = Math.min(dp[i][j], matrix[i][j] + dp[i + 1][j - 1]);
                    }
                    if (j + 1 < col) {
                        dp[i][j] = Math.min(dp[i][j], matrix[i][j] + dp[i + 1][j + 1]);
                    }
                }

            }
        }

        int res = Integer.MAX_VALUE;
        for (int j = 0; j < col; j++) {
            res = Math.min(res, dp[0][j]);
        }

        return res;
    }

    public static int minFallingPathSumOption(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        int[] dp = new int[col];
        Arrays.fill(dp, Integer.MAX_VALUE);
        int sentinel = 0;

        for (int i = row - 1; i >= 0; i--) {
            for (int j = 0; j < col; j++) {
                if (i == row - 1) {
                    dp[j] = matrix[i][j];
                } else {
                    sentinel = dp[j];
                    dp[j] = matrix[i][j] + dp[j];
                    if (j - 1 >= 0) {
                        dp[j] = Math.min(dp[j], matrix[i][j] + sentinel);
                    }
                    if (j + 1 < col) {
                        dp[j] = Math.min(dp[j], matrix[i][j] + dp[j + 1]);
                    }
                }

            }
        }

        int res = Integer.MAX_VALUE;
        for (int j = 0; j < col; j++) {
            res = Math.min(res, dp[j]);
        }

        return res;
    }
}
