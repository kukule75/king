package stack;

import sun.security.util.Length;

import java.util.Stack;

/**
 * @author kinden
 *
 * 根据逆波兰表示法，求表达式的值。
 * 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 *
 * 说明：
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 *
 * 输入: ["2", "1", "+", "3", "*"]
 * 输出: 9
 * 解释: ((2 + 1) * 3) = 9
 *
 * 输入: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
 * 输出: 22
 * 解释:
 *   ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 */
public class EvalRPN {

    public static void main(String[] args) {

        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};

        System.out.println(evalRPN(tokens));
    }

    public static int evalRPN(String[] tokens) {

        int[] stack = new int[tokens.length];
        int k = -1;

        for (int i = 0; i < tokens.length; i++) {
            switch (tokens[i]) {
                case "+":
                    stack[k - 1] += stack[k];
                    k--;
                    break;
                case "-":
                    stack[k - 1] -= stack[k];
                    k--;
                    break;
                case "*":
                    stack[k - 1] *= stack[k];
                    k--;
                    break;
                case "/":
                    stack[k - 1] /= stack[k];
                    k--;
                    break;
                default:
                    stack[++k] = Integer.valueOf(tokens[i]);
            }
        }

        return stack[k];
    }

    /**
     * 使用java内置栈
     * @param tokens
     * @return
     */
    public static int evalRPNA(String[] tokens) {

        if (tokens.length == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            String e = tokens[i];
            if (e.equals("+")) {
                int op1 = stack.pop();
                int op2 = stack.pop();
                stack.push(op1 + op2);
            } else if (e.equals("-")){
                int op1 = stack.pop();
                int op2 = stack.pop();
                stack.push(op2 - op1);
            } else if (e.equals("*")) {
                int op1 = stack.pop();
                int op2 = stack.pop();
                stack.push(op1 * op2);
            } else if (e.equals("/")) {
                int op1 = stack.pop();
                int op2 = stack.pop();
                stack.push(op2 / op1);
            } else {
                stack.push(Integer.valueOf(e));
            }
        }

        return stack.pop();
    }
}
