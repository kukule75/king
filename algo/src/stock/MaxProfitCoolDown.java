package stock;

/**
 * @author kinden
 *
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 *
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 *
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 *
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 *
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 */
public class MaxProfitCoolDown {

    public static void main(String[] args) {

        int[] prices = {1,2,3,0,2};

        System.out.println(maxProfitC(prices));
    }

    // 动态规划
    // 状态集合有两种：天数、是否持有股票，持有股票收益下降，卖出股票收益上升
    // 如果i天没有股票，要么i-1天就没有股票，要么i-1持有i天卖掉了
    // 如果i天有股票，要么i-1天就有股票，要么i-2天没有i天买入了
    public static int maxProfitC(int[] prices) {

        int len = prices.length;

        int dp_i_0 = 0;// 起始如果没有股票，收益为0
        int dp_i_1 = Integer.MIN_VALUE;// 起始如果有股票，收益为负

        int dp_pre_0 = 0;// 代表i-2不持有股票

        for (int i = 0; i < len; i++) {
            int temp = dp_i_0; // i-1
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]); // i
            dp_i_1 = Math.max(dp_i_1, dp_pre_0 - prices[i]); // i
            dp_pre_0 = temp; // i + 1
        }

        return dp_i_0;
    }
}
