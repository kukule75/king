import java.util.HashMap;
import java.util.Map;

/**
 * @author kinden
 *
 * https://leetcode-cn.com/problems/longest-palindrome/
 */
public class LongestPalindrome409 {

    public static void main(String[] args) {

        String s = "ccc";

        System.out.println(longestPalindrome(s));
    }

    private static int longestPalindrome(String s) {

        int[] count = new int[124];

        char[] cs = s.toCharArray();

        for (int i = 0; i < cs.length; i++) {
            count[cs[i]]++;
        }

        int max = 0;

        // 此种写法容易想到，是偶数就相加，是奇数就减一再相加，如果长度为偶数，需要再加一个中间位
        for (int i = 0; i < count.length; i++) {
            if ((count[i] & 1) == 0) {
                max += count[i];
            } else {
                if (count[i] > 1 ) {
                    max += count[i] - 1;
                }
                if ((max & 1) == 0) {
                    max++;
                }
            }
        }

        // 换一种写法，代码比较简洁
        for (int v: count) {
            max += v / 2 * 2;
            if ((v & 1) == 1 && (max & 1) == 0)
                max++;
        }

        return max;

    }
}
