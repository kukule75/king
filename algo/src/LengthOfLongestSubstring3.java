import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author kinden
 */
public class LengthOfLongestSubstring3 {

    public static void main(String[] args) {

        String s = "abba";

        System.out.println(lengthOfLongestSubstringB(s));

    }

    public static int lengthOfLongestSubstringB(String s) {

        char[] c = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();

        int max = 0;
        for (int i = 0, j = 0; j < c.length; j++) {
            if (map.containsKey(c[j])) {

                i = Math.max(map.get(c[j]), i);

            }

            map.put(c[j], j + 1);
            int e = j- i + 1;
            max = Math.max(max, e);
        }

        return max;

    }


    public static int lengthOfLongestSubstringA(String s) {

        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    // 暴力
    public static int lengthOfLongestSubstring(String s) {

        char[] c = s.toCharArray();

        if (c.length == 0) {
            return 0;
        }

        Set<Character> set = new HashSet<>();
        int max = 1;
        int cur = 0;

        for (int i = 0; i < c.length; i++) {
            for (int j = i; j < c.length; j++) {
                if (set.contains(c[j])) {
                    set.clear();
                    max = max >= cur ? max : cur;
                    cur = 0;
                    break;
                } else {
                    set.add(c[j]);
                    cur++;
                }
            }
        }

        return max;
    }
}
