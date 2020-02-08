package stock;

/**
 * @author kinden
 *
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 *
 * 给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。
 * 你可以无限次地完成交易，但是你每次交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 * 返回获得利润的最大值。
 *
 * 输入: prices = [1, 3, 2, 8, 4, 9], fee = 2
 * 输出: 8
 * 解释: 能够达到的最大利润:
 * 在此处买入 prices[0] = 1
 * 在此处卖出 prices[3] = 8
 * 在此处买入 prices[4] = 4
 * 在此处卖出 prices[5] = 9
 * 总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 *
 */
public class MaxProfitFee {

    public static void main(String[] args) {

        int[] prices = {1, 3, 2, 8, 4, 9};

        System.out.println(maxProfitC(prices, 2));
    }

    // 动态规划
    // 状态集合有两种：天数、是否持有股票，持有股票收益下降，卖出股票收益上升
    // 如果i天没有股票，要么i-1天就没有股票，要么i-1持有i天卖掉了
    // 如果i天有股票，要么i-1天就有股票，要么i-2天没有i天买入了
    // 手续费买入、卖出只需扣一次，只能在卖出的时候扣除
    public static int maxProfitC(int[] prices, int fee) {

        int len = prices.length;

        int dp_i_0 = 0;// 起始如果没有股票，收益为0
        int dp_i_1 = Integer.MIN_VALUE;// 起始如果有股票，收益为负

        for (int i = 0; i < len; i++) {
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]); // i
            dp_i_1 = Math.max(dp_i_1, dp_i_0 - prices[i] - fee); // i
        }

        return dp_i_0;
    }
}
