package math;

/**
 * @author kinden
 * 颠倒给定的 32 位无符号整数的二进制位。
 *
 * 输入: 00000010100101000001111010011100
 * 输出: 00111001011110000010100101000000
 * 解释: 输入的二进制串 00000010100101000001111010011100 表示无符号整数 43261596，
 *       因此返回 964176192，其二进制表示形式为 00111001011110000010100101000000。
 *
 * 输入：11111111111111111111111111111101
 * 输出：10111111111111111111111111111111
 * 解释：输入的二进制串 11111111111111111111111111111101 表示无符号整数 4294967293，
 *       因此返回 3221225471 其二进制表示形式为 10101111110010110010011101101001。
 */
public class ReverseBits {

    public static void main(String[] args) {

        int num = 43261596;//10100101000001111010011100
        String s = Integer.toBinaryString(num);
//        System.out.println(s);
        System.out.println(reverseBits(43261596));
        System.out.println(reverseBitsA(43261596));
    }

    public static int reverseBits(int n) {
        int result = 0;

        for (int i = 0; i <= 32; i++) {
            int temp = n >> i;
            temp &= 1;
            temp = temp << (31 - i);
            result |= temp;
        }

        return result;

    }

    public static int reverseBitsA(int n) {
        int result = 0;
        for (int i = 0; i <= 32; i++) {
            // 1. 将给定的二进制数,由低到高位逐个取出
            // 1.1 右移 i 位,
            int tmp = n >> i;
            // 1.2  取有效位
            tmp = tmp & 1;
            // 2. 然后通过位运算将其放置到反转后的位置.
            tmp = tmp << (31 - i);
            // 3. 将上述结果再次通过运算结合到一起
            result |= tmp;
        }
        return result;
    }
}
