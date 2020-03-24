import java.util.Arrays;

/**
 * @author kinden
 *
 * 每种币值使用不限次数
 * 变种有每种币值使用限制s次，当然s可以等于1
 * 提示，画一下递归树
 */
public class CoinChange322 {

    public static void main(String[] args) {

        int[] coins = {1, 2, 5};

//        System.out.println(coinChange(coins,11));
//        System.out.println(coinChangeRecurse(coins,11));
        System.out.println(coinChangeDynamic(coins,11));
    }

    // 2.动态规划，自底向上，复杂度O(Sn)
    public static int coinChangeDynamic(int[] coins, int amount) {

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]]);
                }
            }
            dp[i]++;
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    // 1.递归，自顶向下，使用记忆化的可以降低复杂度，画出递归树，可以知道复杂度为O(nS)
    // n为面值数组长度，S为金额
    public static int coinChangeRecurse(int[] coins, int amount){

        int[] men = new int[amount+1];
        // amount就是某个面值
        for (int i = 0; i < coins.length; i++) {
            men[coins[i]] = 1;
        }

        return coinChangeRecurseHelper(coins, amount, men);
    }

    public static int coinChangeRecurseHelper(int[] coins, int amount, int[] men) {

        if (amount < 0) {
            return -1;
        }

        // 也就是amount金额在面值数组中存在
        // 也可以使用查表法减少 amount等于0 的函数调用
//        if (amount == 0) {
//            return 0;
//        }

        if (men[amount] != 0) {
            System.out.println("hit cache, coinChangeRecurseHelper("+amount+") ="+ men[amount]);
            return men[amount];
        }

        System.out.println("coinChangeRecurseHelper("+amount+") =");

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < coins.length; i++) {
            int e = coinChangeRecurseHelper(coins, amount - coins[i], men);
            if (e >= 0 && e < min) {
                min = e;
            }
        }

        int res = (min == Integer.MAX_VALUE) ? -1 : min + 1;
        men[amount] = res;

//        System.out.println("set men["+amount+"] = "+res);

        return res;
    }


    // 0.暴力，这个方式思维是错误的，不一定要先最大面额的先除尽分配
    // 贪心思维，但是结果不对，如果局部最优不代表全局最优，就不能用贪心思维
    public static int coinChange(int[] coins, int amount) {

        Arrays.sort(coins);

        int count = 0;

        int e;
        int k = amount;

        for (int j = coins.length - 1; j >=0 ; j--) {
            int i = j;
            while (k != 0 && i >= 0) {
                e = k / coins[i];
                k = k % coins[i];
                count += e;
                i--;
            }

            if (k == 0) {
                return count;
            } else {
                count = 0;
                k = amount;
            }
        }

        return -1;
    }
}
