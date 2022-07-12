package dynamic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * f(n) = 1 + min(f(n-1),f(n-2),f(n-5))
 * .
 * .
 * .
 * f(11) = 1 + min(f(10),f(8),f(6))
 * f(10) = 1 + min(f(9),f(8),f(5))
 * f(9) = 1 + min(f(8),f(7),f(4))
 * f(8) = 1 + min(f(7),f(6),f(3))
 * f(7) = 1 + min(f(6),f(5),f(2))
 * f(6) = 1 + min(f(5),f(4),f(1))
 */
public class CoinChange {

    public static void main(String[] args) {

        int[] coins = {2};

        int count = coinChange(coins, 3);

        System.out.println(count);
    }

    public static int coinChange(int[] coins, int amount) {

//        return dp(coins, amount) ;
//        return dpWithMemo(coins, amount, new int[amount + 1]);
        return dynamic(amount, coins);
    }

    // 实际就是如何填充dp表
    public static int dynamic(int amount, int[] coins) {

        int Max = amount + 1;
        int[] dp = new int[Max];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        return dp[amount] == Max ? -1 : dp[amount];
    }

    /**
     * 第一种方法，暴力递归
     *
     * 递归算法的时间复杂度分析：子问题总数 x 解决每个子问题所需的时间。
     *
     * 假设目标金额为 n，给定的硬币个数为 k，那么递归树最坏情况下高度为 n（全用面额为 1 的硬币），
     * 然后再假设这是一棵满 k 叉树，则节点的总数在 k^n 这个数量级。
     *
     * 接下来看每个子问题的复杂度，由于每次递归包含一个 for 循环，复杂度为 O(k)，相乘得到总时间复杂度为 O(k^n)，指数级别。
     */
    public static int dp(int[] coins, int amount) {

        if (amount < 0) {
            return -1;
        }

        if (amount == 0) {
            return 0;
        }

        int remain;
        // 每次循环的最少硬币数
        int temp = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            remain = amount - coins[i];
            int dp = dp(coins, remain);
            if (dp == -1) {
                continue;
            }
            temp = Math.min(dp, temp);
        }

        return (temp == Integer.MAX_VALUE)  ? -1 : ++temp;
    }

    // 第二种，带备忘录的递归
    public static int dpWithMemo(int[] coins, int amount, int[] memo) {

        if (amount < 0) {
            return -1;
        }

        if (amount == 0) {
            return 0;
        }

        if (memo[amount] != 0) {
            return memo[amount];
        }

        // 每次循环的最少硬币数
        int temp = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int dp;
            dp = dpWithMemo(coins, amount - coins[i], memo);
            if (dp == -1 ) {
                continue;
            }
            temp = Math.min(dp, temp);
        }

        int res = temp == Integer.MAX_VALUE ? -1 : ++temp;
        memo[amount] = res;
        return res;
    }
}
