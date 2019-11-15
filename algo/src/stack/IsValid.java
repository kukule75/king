package stack;

import java.util.Stack;

/**
 * @author kinden
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 输入: "()[]{}"
 * 输出: true
 *
 * 输入: "{[]}"
 * 输出: true
 */
public class IsValid {

    public static void main(String[] args) {

        String s = "()[]{}";

        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {

        int len = s.length();

        //奇数长度，直接返回
        if ((len & 1) == 1) {
            return false;
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < len; i++) {
            if (stack.empty()) {
                stack.push(s.charAt(i));
            } else {
                char e = s.charAt(i);
                if (e == ')' && stack.peek() == '(' ||
                        e == '}' && stack.peek() == '{' ||
                        e == ']' && stack.peek() == '[') {
                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                    //栈长度大于字符串一半，直接返回
                    if (stack.size() > (len /2)) {
                        return false;
                    }
                }
            }
        }

        return stack.empty();
    }
}
