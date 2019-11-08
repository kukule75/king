package array;

/**
 * @author kinden
 *
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 *
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 *
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 *
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 */
public class ReverseWords {

    public static void main(String[] args) {

        String s = "  hello world!  ";

//        String s = "a";
//        String s = "the sky is blue";
        System.out.println(reverseWords(s));
    }

    //非原地
    public static String reverseWords(String s) {

        char[] cs = s.toCharArray();
        int len = cs.length;
        StringBuilder sb = new StringBuilder();

        int j = len - 1;
        while (j >= 0) {
            int i = j;
            while (i >= 0 && cs[i] == ' ') {//注意需要>=0
                i--;
            }

            j = i;
            while (j >= 0 && cs[j] != ' ') {//注意需要>=0
                j--;
            }

            if (i > j) {//注意需要i > j，相等就说明没有word
                sb.append(cs, j + 1, i - j).append(' ');
            }
        }

        return sb.length() > 0 ? sb.substring(0, sb.length() - 1) : "";

    }
}
