package math;

/**
 * @author kinden
 * <p>
 * 编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
 * <p>
 * 输入：00000000000000000000000000001011
 * 输出：3
 * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
 */
public class HammingWeight {

    public static void main(String[] args) {
        System.out.println(hammingWeight(43261596));
    }

    // 通过右移操作，让最后一位与1与操作
    public static int hammingWeight(int n) {

        int count = 0;

        for (int i = 0; i < 32; i++) {
            int temp = n >> i;
            if ((temp &= 1) == 1) {
                count++;
            }
        }

        return count;
    }


    // n & (n - 1)消除n的最后一个1
    public static int hammingWeightA(int n) {

        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }

        return count;
    }
}
