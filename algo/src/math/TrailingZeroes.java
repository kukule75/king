package math;

/**
 * @author kinden
 *
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 *
 * 说明: 你算法的时间复杂度应为 O(log n) 。
 *
 * 输入: 3
 * 输出: 0
 * 解释: 3! = 6, 尾数中没有零。
 *
 * 输入: 5
 * 输出: 1
 * 解释: 5! = 120, 尾数中有 1 个零.
 */
public class TrailingZeroes {

    public static void main(String[] args) {
        System.out.println(trailingZeroes(10));
    }

    public static int trailingZeroes(int n) {

//        while ((n % 5) != 0) {
//            n--;
//        }
//
//        return n/5;
        int sum5 = 0;
        while(n != 0)
        {
            n = n/5;//下一次的数
            sum5 += n;//这一次包含多少个5
        }

        return sum5;
    }
}
