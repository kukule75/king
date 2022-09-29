package doublePoint.window;

// 3
public class LengthOfLongestSubstring {

    public static void main(String[] args) {

        String s = "abcabcbb";

        System.out.println(lengthOfLongestSubstring(s));

    }

    public static int lengthOfLongestSubstring(String s) {

        int[] men = new int[128];

        int left = 0;
        int right = 0;
        int count = Integer.MIN_VALUE;

        char c;
        while (right < s.length()) {
            c = s.charAt(right);
            men[c]++;
            right++;

            while (men[c] > 1) {
                char d = s.charAt(left);
                men[d]--;
                left++;
            }
            count = Math.max(count, right - left);
        }

        return count;

    }
}
