package array;

import java.util.Arrays;

/**
 * @author kinden
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 */
public class ReverseString {

    public static void main(String[] args) {

        char[] str = {'h','e', 'l', 'l', 'o'};

//        reverseString(str);

        recurse(str);

        System.out.println(Arrays.toString(str));
    }

    // 迭代法
    private static void reverseString(char[] str) {

        char temp;

        for (int i = 0, j = str.length - 1; i <= j; i++, j--) {
            temp = str[i];
            str[i] = str[j];
            str[j] = temp;
        }
    }

    // 递归法
    private static void recurse(char[] str) {

        recurseHelper(0, str.length - 1, str);
    }

    private static void recurseHelper(int start, int end, char[] ch) {

        if (start >= end) {
            return;
        }

        char temp = ch[start];
        ch[start] = ch[end];
        ch[end] = temp;

        recurseHelper(start + 1, end - 1, ch);
    }
}
