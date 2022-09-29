package doublePoint.window;

import java.util.Arrays;

// 567
// s2 是否包含 s1的排列
public class CheckInclusion {


    public static void main(String[] args) {
//        String s1 = "ac";
//        String s2 = "eidbaooo";
//        String s1 = "ab";
//        String s2 = "eidboaoo";
        String s1 = "ab";
        String s2 = "eidbaooo";

        System.out.println(checkInclusionA(s1, s2));
    }

    public static boolean checkInclusionA(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) {
            return false;
        }
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for (int i = 0; i < n; ++i) {
            ++cnt1[s1.charAt(i) - 'a'];
            ++cnt2[s2.charAt(i) - 'a'];
        }
        if (Arrays.equals(cnt1, cnt2)) {
            return true;
        }
        for (int i = n; i < m; ++i) {
            ++cnt2[s2.charAt(i) - 'a'];
            --cnt2[s2.charAt(i - n) - 'a'];
            if (Arrays.equals(cnt1, cnt2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkInclusion(String s1, String s2) {

        if (s2.length() < s1.length()) {
            return false;
        }

        int sign = 0;
        int[] men = new int[128];
        int[] cur = new int[128];
        for (int i = 0; i < s1.length(); i++) {
            men[s1.charAt(i)]++;
        }

        int left = 0;
        int right = 0;
        while (right < s2.length()) {

            char c = s2.charAt(right);
            // 不是s1的字符，直接扩大窗口
            if (men[c] == 0) {
                right++;
                continue;
            }

            if (cur[c] < men[c]) {
                sign++;
            }
            cur[c]++;
            right++;

            while (sign == s1.length()) {
                if (right - left== s1.length()) {
                    return true;
                }
                char c1 = s2.charAt(left);
                if (men[c1] > 0  && --cur[c1] < men[c1]) {
                    sign--;
                }
                left++;
            }

        }

        return false;
    }


}
