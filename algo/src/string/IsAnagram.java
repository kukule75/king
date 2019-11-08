package string;

/**
 * @author kinden
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 *
 * 你可以假设字符串只包含小写字母。
 */
public class IsAnagram {

    public static void main(String[] args) {

        String s = "anagram";
        String t = "nagaram";

        System.out.println(isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {

        int lenS = s.length();
        int lenT = t.length();

        if (lenS != lenT) {
            return false;
        }

        int[] letterS = new int[26];

        char[] chs = s.toCharArray();
        char[] cht = t.toCharArray();

        for (int i = 0; i < lenS; i++) {
            letterS[chs[i] - 'a']++;
            letterS[cht[i] - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (letterS[i] != 0) {
                return false;
            }
        }

        return true;
    }

}
