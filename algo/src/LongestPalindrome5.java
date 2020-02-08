/**
 * @author kinden
 *
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 */
public class LongestPalindrome5 {

    public static void main(String[] args) {

        String s = "b";

//        System.out.println(longestPalindrome(s));
        System.out.println(longestPalindromeA(s));
//        System.out.println(expandCenter("abba".toCharArray(), 1, 2));
    }

    /**
     * 动态规划
     */
    private static String longestPalindromeA(String s) {

        if (s == null || s.length() == 0) {
            return "";
        }

        char[] cs = s.toCharArray();

        int len = cs.length;

        int max = 1;
        int start = 0;

        // dp[i][j]表示s[i,j]子串是否问回文数
        boolean[][] dp = new boolean[len][len];

        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (cs[i] == cs[j]) {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                } else {
                    dp[i][j] = false;
                }

                if (dp[i][j]) {
                    int cur = j - i + 1;
                    if (cur > max) {
                        max = cur;
                        start = i;
                    }
                }
            }
        }

        return s.substring(start, start + max);
    }

    /**
     * 中心扩展法，回文串从中心两边扩展，都是相同的字符
     */
    private static String longestPalindrome(String s) {

        if (s == null || s.length() == 0) {
            return "";
        }
        char[] cs = s.toCharArray();

        int start = 0, end = 0;

        for (int i = 0; i < cs.length; i++) {
            int len1 = expandCenter(cs, i, i);
            int len2 = expandCenter(cs, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start + 1) {
                start = i - (len - 1)/2;
                end = i + len/2;
            }
        }

        return s.substring(start, end + 1);
    }

    private static int expandCenter(char[] cs, int left, int right) {

        int l = left;
        int r = right;

        while (l >= 0 && r < cs.length && cs[l] == cs[r] ) {
            l--;
            r++;
        }

        return r -l - 1;
    }


}
