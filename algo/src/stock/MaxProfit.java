package stock;

/**
 * @author kinden
 *
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 *
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 * 注意你不能在买入股票前卖出股票。
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 *
 *
 * 1.暴力解法
 */
public class MaxProfit {

    public static void main(String[] args) {

        int[] prices = {10,2,9,1,2,1,3,1};

        System.out.println(maxProfitC(prices));
    }

    // 动态规划
    // 状态集合有两种：天数、是否持有股票，持有股票收益下降，卖出股票收益上升
    // 如果i天没有股票，要么i-1天就没有股票，要么i-1持有i天卖掉了
    // 如果i天有股票，要么i-1天就有股票，要么i-1天没有i天买入了
    public static int maxProfitC(int[] prices) {

        int len = prices.length;

        int dp_i_0 = 0;// 起始如果没有股票，收益为0
        int dp_i_1 = Integer.MIN_VALUE;// 起始如果有股票，收益为负

        for (int i = 0; i < len; i++) {
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, dp_i_0 - prices[i]);
        }

        return dp_i_0;
    }

    // 遍历过程中，记录最小的买入金额，并且计算当前卖出价格的收益，并判断是否为当前的最大收益
    public static int maxProfitB(int[] prices) {

        int len = prices.length;

        int maxProfit = 0;

        int minBuy = Integer.MAX_VALUE;

        for (int i = 0; i < len; i++) {
            if (prices[i] <= minBuy) {
                minBuy = prices[i];
            }
            int curProfit = prices[i] - minBuy;
            if (curProfit >= maxProfit) {
                maxProfit = curProfit;
            }
        }

        return maxProfit;
    }

    // 暴力优化，针对于123456这种能有效优化
    public static int maxProfitA(int[] prices) {

        int len = prices.length;

        int maxProfit = 0;

        for (int i = 0; i < len; i++) {
            if (i > 1 && prices[i] > prices[i-1]) {
                continue;
            }
            for (int j = i+1; j < len; j++) {
                int cur = prices[j] - prices[i];
                maxProfit = maxProfit >= cur ? maxProfit : cur;
            }
        }

        return maxProfit;
    }

    // 暴力
    public static int maxProfit(int[] prices) {

        int len = prices.length;

        int maxProfit = 0;

        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                int cur = prices[j] - prices[i];
                maxProfit = maxProfit >= cur ? maxProfit : cur;
            }
        }

        return maxProfit;
    }
}
