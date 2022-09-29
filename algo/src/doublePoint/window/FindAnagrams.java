package doublePoint.window;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 438
// s中包含p
public class FindAnagrams {

    public static void main(String[] args) {
//        String s = "cbaebabacd";
//        String p = "abc";

        String s = "abab";
        String p = "ab";

        List<Integer> anagrams = findAnagrams(s, p);

        anagrams.forEach(System.out::println);
    }

    public static List<Integer> findAnagramsA(String s, String p) {

        List<Integer> anagrams = new ArrayList<>();

        int[] smen = new int[128];
        int[] pmen = new int[128];

        char c;
        for (int i = 0; i < p.length(); i++) {
            c = p.charAt(i);
            pmen[c]++;
//            smen[c]++;
        }

        int left = 0;
        int right = 0;
        int count = 0;
        while (right < s.length()) {
            c = s.charAt(right);
            if (pmen[c] == 0) {
                right++;
                continue;
            }

            if (smen[c] < pmen[c]) {
                count++;
            }
            smen[c]++;
            right++;
            int pLen = p.length();
            while (count == pLen) {
                if (right - left == pLen) {
                    anagrams.add(left);
                }
                char c1 = s.charAt(left);
                if (pmen[c1] > 0 && --smen[c1] < pmen[c1]) {
                    count--;
                }
                left++;
            }
        }

        return anagrams;
    }

    public static List<Integer> findAnagrams(String s, String p) {

        List<Integer> anagrams = new ArrayList<>();

        int[] smen = new int[128];
        int[] pmen = new int[128];

        char c;
        for (int i = 0; i < p.length(); i++) {
            c = p.charAt(i);
            pmen[c]++;
            smen[c]++;
        }

        int pLen = p.length();
        for (int i = pLen; i < s.length(); i++) {
            if (Arrays.equals(smen, pmen)) {
                anagrams.add(i - pLen);
            }
            smen[s.charAt(i)]--;
            smen[s.charAt(i - pLen)]++;
        }

        return anagrams;
    }
}
