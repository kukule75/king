package recurse;

/**
 * @author kinden
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 */
public class ClimbStairs70 {

    public static void main(String[] args) {


//        System.out.println(climbStairs(4));
        System.out.println(dynamicA(4));

    }

    // 第 i 阶可以由以下两种方法得到：
    // 在第 (i−1) 阶后向上爬1阶。
    // 在第 (i−2) 阶后向上爬2阶。
    // 第i阶梯的走法dp[i]，可以有公式dp[i-1]+dp[i-2]
    public static int dynamic(int n) {

        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }

    // 使用两个变量，节省内存
    public static int dynamicA(int n) {

        if (n <= 2) {
            return n;
        }

        int i = 1;
        int j = 2;

        for (int k = 3; k <= n; k++) {
            int e = i + j;
            i = j;
            j = e;
        }

        return j;
    }

    // 递归法，也就是斐波那契数列，当然可以优化成记忆的递归，避免重复计算
    public static int climbStairs(int n) {

        int[] men = new int[n + 1];
        return helper(n, men);
    }

    private static int helper(int n, int[] men) {

        if (n <= 0) {
            return 0;
        }

        if (n <= 2) {
            return n;
        }

        if (men[n] > 0) {
            return men[n];
        }

        men[n] = helper(n-1, men) + helper(n-2, men);
        return men[n];
    }
}
