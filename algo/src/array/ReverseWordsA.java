package array;

/**
 * @author kinden
 *
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *
 * 输入: "Let's take LeetCode contest"
 * 输出: "s'teL ekat edoCteeL tsetnoc"
 *
 * 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 */
public class ReverseWordsA {

    public static void main(String[] args) {

//        String s = "Let's take LeetCode contest";
        String s = "take";

        System.out.println(reverseWords(s));
    }

    public static String reverseWords(String s) {

        int len = s.length();
        int j = 0;

        char[] cs = s.toCharArray();

        while (j <= len - 1) {
            int i = j;
            while (i < len && cs[i] == ' ') {
                i++;
            }
            j = i;
            while (j < len && cs[j] != ' ') {
                j++;
            }

            for (int k = i, h = j - 1; k < h; k++, h--) {
                char temp = cs[k];
                cs[k] = cs[h];
                cs[h] = temp;
            }
        }

        return new String(cs);

    }
}
