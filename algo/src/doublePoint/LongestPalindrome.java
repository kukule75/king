package doublePoint;

// 5
public class LongestPalindrome {

    public static void main(String[] args) {
        String s = "babad";

        System.out.println(longestPalindrome(s));
    }

    // double points
    public static String longestPalindrome(String s) {

        String res = "";
        String temp;
        for (int i = 0; i < s.length(); i++) {
            String a = palindrome(s, i, i);
            String b = palindrome(s, i, i + 1);
            temp = a.length() >= b.length() ? a : b;

            res = res.length() >= temp.length() ? res : temp;
        }

        return res;
    }

    public static String palindrome(String s, int i, int j) {
        char[] chars = s.toCharArray();
        while ((i >=0) && (j <= s.length() - 1) && (chars[i] == chars[j])) {
            i--;
            j++;
        }

        return s.substring(i+1, j);
    }
}
