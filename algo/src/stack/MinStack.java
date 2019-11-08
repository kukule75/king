package stack;

import java.util.Stack;

/**
 * @author kinden
 *
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 */
public class MinStack {

    private Stack<Integer> minStack;
    private Stack<Integer> stack;

    public MinStack() {
        minStack = new Stack<>();
        stack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.empty() || minStack.peek() >= x) {
            minStack.push(x);
        }
    }

    public void pop() {
        if (stack.empty() || minStack.empty()) {
            return;
        }
        if (stack.pop().equals(minStack.peek())) {
            minStack.pop();
        }
    }

    public int top() {
        if (!stack.empty()) {
            return stack.peek();
        }
        throw new RuntimeException("1");
    }

    public int getMin() {
        if (!minStack.empty()) {
            return minStack.peek();
        }
        throw new RuntimeException("2");
    }

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<Integer>();
    }
}