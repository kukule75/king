package other;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author kinden
 */
public class Path {

    public static void main(String[] args) {

        String str = "\\data\\logs\\..\\log1\\log2\\.";

        String[] strs = str.split("\\\\");

        Stack<String> in = new Stack<>();

        for (int i = 0; i < strs.length; i++) {
            if (strs[i].equals("..") && !in.empty()) {
                in.pop();
            } else if (!strs[i].equals(".")) {
                in.push(strs[i]);
            }
        }

        Stack<String> out = new Stack<>();

        while (!in.empty()) {
            out.push(in.pop());
        }

        StringBuilder sb = new StringBuilder();
        while (!out.empty()) {
            sb.append("\\");
            sb.append(out.pop());
        }

        System.out.println(sb.toString());
    }
}
