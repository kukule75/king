package BFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class OpenLock {

    public static void main(String[] args) {

        String[] deadends = {"0201","0101","0102","1212","2002"};

        System.out.println(openLock(deadends, "0202"));
    }

    public static int openLock(String[] deadends, String target) {
        // 死亡组合
        Set<String> deadendsSet = new HashSet<>();
        // 已遍历的组合
        Set<String> visitedSet = new HashSet<>();

        for (int i = 0; i < deadends.length; i++) {
            deadendsSet.add(deadends[i]);
        }

        int step = 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String ps = queue.poll();

                /**
                 * 遇到死亡组合，跳过，此路不通
                 */
                if (deadendsSet.contains(ps)) {
                    continue;
                }

                /**
                 * 如果目标，返回步数
                 */
                if (ps.equals(target)) {
                    return step;
                }

                for (int j = 0; j < 4; j++) {
                    String plus = plusOne(ps, j);
                    if (!visitedSet.contains(plus)) {
                        queue.add(plus);
                        visitedSet.add(plus);
                    }
                    String minus = minusOne(ps, j);
                    if (!visitedSet.contains(minus)) {
                        queue.add(minus);
                        visitedSet.add(minus);
                    }
                }
            }

            step++;
        }

        return -1;
    }

    public static String plusOne(String password, int i) {

        char[] chars = password.toCharArray();
        if (chars[i] == '9') {
            chars[i] = '0';
        } else {
            chars[i] += 1;
        }

        return String.valueOf(chars);
    }

    public static String minusOne(String password, int i) {

        char[] chars = password.toCharArray();
        if (chars[i] == '0') {
            chars[i] = '9';
        } else {
            chars[i] -= 1;
        }

        return String.valueOf(chars);
    }
}
