package stock;

/**
 * @author kinden
 *
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 *
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 *
 * 输入: [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
 *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 *
 */
public class MaxProfitII {

    public static void main(String[] args) {

        int[] prices = {1, 7, 2, 3, 6, 7, 6, 7};

        System.out.println(maxProfitC(prices));
        System.out.println(maxProfitA(prices));
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

    // 递增就相加，比如1，4，7
    // 4-1 + 7-4 = 6 = 7 -1
    public static int maxProfitA(int[] prices) {

        int len = prices.length;

        int maxProfit = 0;

        for (int i = 1; i < len; i++) {

            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }

        return maxProfit;
    }

    // 先找最小买入点，然后往后找卖出点，也就是最小买入点之后的比买入点要大的数，如果卖出点
    // 连续递增，那么只要找到最后一个卖出点，卖出之后，继续找买入点
    public static int maxProfit(int[] prices) {

        int len = prices.length;

        int maxProfit = 0;

        int l = 0;
        int h = 0;
        int i = 0;
        while (i < len - 1) {
            // [7,1,5,3,6,4]
            while (i < len - 1 && prices[i] >= prices[i + 1]){
                i++;
            }
            l = prices[i];
            while (i < len - 1 && prices[i] <= prices[i + 1]) {
                i++;
            }
            h = prices[i];
            maxProfit += h - l;
        }

        return maxProfit;
    }
}
