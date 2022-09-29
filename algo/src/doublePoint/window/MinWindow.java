package doublePoint.window;

import java.util.HashMap;
import java.util.Map;

// 76
public class MinWindow {

    public static void main(String[] args) {

//        String s = "ADOBECODEBANC";

//        String s = "EBBANCF";

//        String s = "aa";

//        String s = "cabwefgewcwaefgcf";

//        System.out.println(minWindowUserArray(s, "aa"));

//        System.out.println("as".substring(1,2));
    }

    // 使用数组标记
    public static String minWindowUserArray(String s, String t) {

        int[] tSign = new int[128];
        int[] window = new int[128];

        char[] tChars = t.toCharArray();
        for (int i = 0; i < tChars.length; i++) {
            tSign[tChars[i]]++;
        }

        char[] sChars = s.toCharArray();
        int left = 0;
        int right = 0;
        // 窗口中字母是否与t中一直，count = t.length，表示一致
        int count = 0;

        int ansL = -1;
        int ansR = -1;
        int len = Integer.MAX_VALUE;

        while (right < sChars.length) {

            char r = sChars[right];

            // tSign=0，说明不属于t的字符
            if (tSign[r] == 0) {
                right++;//扩大窗口
                continue;
            }

            // 到了这一步，说明r属于t中的字母；如果window[r] < tSign[r]，说明窗口中r字母还没有达到t中的个数，更新count值
            if (window[r] < tSign[r]) {
                count++;
            }
            // r属于t中的字符
            window[r]++;
            right++;//扩大窗口

            // 窗口中已经包含t中所有的字符，且个数也相同
            while (count == tChars.length) {
                // 更新坐标值
                if (right - left < len) {
                    len = right - left;
                    ansL = left;
                    ansR = right;
                }
                char l = sChars[left];
                // 此次需要移除的字符l
                // window中l字符个数减一，如果小于tSign中l的字符，说明已经破坏了题意，count需要--
                // 为什么需要tSign[l] > 0，因为需要排除不属于t中字符的情况
                if (tSign[l] > 0 && (--window[l] < tSign[l])) {
                    count--;
                }
                left++;// 缩小窗口
            }
        }

        return len == Integer.MAX_VALUE ? "" : s.substring(ansL, ansR);

    }

    // 使用map来保存字符串的状态，判断是否包含所有字母
    public static String minWindow(String s, String t) {

        Map<Character, Integer> tMap = new HashMap<>();
        char[] tChars = t.toCharArray();
        for (int i = 0; i < tChars.length; i++) {
            tMap.compute(tChars[i], (k, v) -> v == null ? 1 : v + 1);
        }

        int left = 0;
        int right = -1;

        char[] sChars = s.toCharArray();
        Map<Character, Integer> window = new HashMap<>();
        int ansL = -1;
        int ansR = -1;
        int len = Integer.MAX_VALUE;
        while (right < sChars.length) {
            right++;
            // 扩大窗口
            if (right < sChars.length && tMap.containsKey(sChars[right])) {
                window.compute(sChars[right], (k, v) -> v == null ? 1 : v + 1);
            }

            // 缩小窗口
            while (left <= right && check(tMap, window)) {
                Integer count = window.get(sChars[left]);
                if (count != null) {
                    if (right - left + 1 < len) {
                        len = right - left + 1;
                        ansL = left;
                        ansR = right;
                    }
                    if (count - 1 > 0) {
                        window.put(sChars[left], count - 1);
                    } else {
                        window.remove(sChars[left]);
                    }
                }
                left++;
            }
        }

        return ansL == -1 ? "" : s.substring(ansL, ansR + 1);
    }

    private static boolean check(Map<Character, Integer> tMap, Map<Character, Integer> window) {

        if (tMap.size() != window.size()) {
            return false;
        }

        return !tMap.entrySet().stream()
                .filter(entry -> entry.getValue() > window.getOrDefault(entry.getKey(), 0))
                .findAny().isPresent();
    }
}
