package string;

/**
 * @author kinden
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 * s = "leetcode"
 * 返回 0.
 *
 * s = "loveleetcode",
 * 返回 2.
 */
public class FirstUniqChar {

    public static void main(String[] args) {

        String s = "cc";

        System.out.println((firstUniqCharA(s)));
    }

    //适合字符串长度大于26的
    public static int firstUniqCharA(String s) {

        int index = -1;
        //反过来，只有26个字符
        for (char ch = 'a'; ch <= 'z'; ch++) {
            int beginIndex = s.indexOf(ch);
            // 从头开始的位置是否等于结束位置，相等说明只有一个，
            if (beginIndex != -1 && beginIndex == s.lastIndexOf(ch)) {
                //取小的，越小代表越前。
                index = (index == -1 || index > beginIndex) ? beginIndex : index;
            }
        }
        return index;
    }

    //适合字符串长度小于26的
    public static int firstUniqChar(String s) {

        char[] cs = s.toCharArray();
        int len = cs.length;

        if (len == 0) {
            return -1;
        }

        int[] seq = new int[26];

        for (int i = 0; i < len; i++) {
            seq[cs[i] - 'a']++;
        }

        for (int i = 0; i < len; i++) {
            if (seq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }
}
