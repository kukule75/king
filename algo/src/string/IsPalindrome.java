package string;

/**
 * @author kinden
 *
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 */
public class IsPalindrome {

    public static void main(String[] args) {

        String s = "A man, a plan, a canal: Panama";

//        String s = "a.";
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {

        char[] cs = s.toCharArray();

        for (int i = 0, j = cs.length - 1; i < j;) {

            char l = ' ';
            while (i <= j) {
                if (('0' <= cs[i] && cs[i] <= '9') || ('a' <= cs[i] && cs[i] <= 'z')) {
                    l = cs[i];
                    break;
                } else if ('A' <= cs[i] && cs[i] <= 'Z') {
                    l = (char)(cs[i] - 'A' + 'a');
                    break;
                } else {
                    i++;
                    continue;
                }
            }

            char r = ' ';
            while (j >= i) {
                if (('0' <= cs[j] && cs[j] <= '9') || ('a' <= cs[j] && cs[j] <= 'z')) {
                    r = cs[j];
                    break;
                } else if ('A' <= cs[j] && cs[j] <= 'Z') {
                    r = (char)(cs[j] - 'A' + 'a');
                    break;
                }else {
                    j--;
                    continue;
                }
            }

            if (r != l) {
                return false;
            }

            i++;
            j--;

        }

        return true;

    }
}
