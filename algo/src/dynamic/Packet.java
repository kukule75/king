package dynamic;

/**
 * @author kinden
 *
 * 背包问题，背包总质量W，备选物品的重量weight，最大重量maxW
 * 解题思路有：
 * 1.回溯
 * 2.动态规划，以空间换时间
 */
public class Packet {

    private static int[] weight = {2,2,4,6,3};

    private static int w = 9;

    private static int maxW = Integer.MIN_VALUE;

    public static void main(String[] args) {

//        f();
//        DynamicF();
        DynamicFa();
        System.out.println(maxW);
    }

    // 动态规划，使用一维数组
    public static void DynamicFa() {

        boolean[] res = new boolean[w+1];

        res[0] = true;
        res[weight[0]] = true;

        // 为什么只计算放入i的情况，因为如果i不放入，就是前面的状态，推到最开始，也就是res[0]与res[weight[0]]
        for (int i = 1; i < weight.length; i++) {
            for (int j = w - weight[i]; j >= 0; j--) {// 为什么从后到前的顺序，避免重复计算
                if (res[j] == true) {
                    res[j + weight[i]] = true;
                }
            }
        }

        for (int i = w; i > 0; i--) {
            if (res[i] == true) {
                maxW = i;
                return;
            }
        }
    }

    // 动态规划
    // O(n*w)。n表示物品个数，w表示背包可以承载的总重量。
    // 以二维数组保持临时状态，空间消耗比较大
    public static void DynamicF() {

        boolean[][] res = new boolean[weight.length][w+1];

        res[0][0] = true;
        res[0][weight[0]] = true;

        for (int i = 1; i < weight.length; i++) {
            // i物件不放入
            for (int j = 0; j <= w; j++) {
                if (res[i-1][j] == true) {// 是前面可能的结果
                    res[i][j] = res[i-1][j];
                }
            }
            // i物件放入，不能超过W；j <= w - weight[i]会提前终止，本来放物品不需要考虑顺序
            // 其实也没关系，后续的物品i还有机会放入尝试
            for (int j = 0; j <= w - weight[i]; j++) {
                if (res[i-1][j] == true) {// 是前面可能的结果
                    res[i][j+weight[i]] = true;
                }
            }
        }

        for (int i = w; i >= 0 ; i--) {
            if (res[weight.length-1][i] == true) {
                maxW = i;
                return;
            }
        }
    }

    // 回溯穷举法，复杂度很高，需要O(2^n)
    public static void f() {
        fHelp(0, 0);
    }
    // 回溯递归器
    private static void fHelp(int i, int cw) {

        if (i == weight.length || cw >= w) {
            maxW = (maxW >= cw) ? maxW : cw;
            return;
        }
        // 不装i
        fHelp(i + 1, cw);
        // 装i
        if (cw + weight[i] <= w) {
            fHelp(i + 1, cw + weight[i]);
        }
    }
}
