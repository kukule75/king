package dynamic;

/**
 * @author kinden
 */
public class FibonacciA {

    public static void main(String[] args) {

        System.out.println(FibonacciA(5));
        System.out.println(FibonacciC(5));
    }

    // 递归，不考虑重复计算问题
    private static int FibonacciA(int cur) {

        if (cur == 1 || cur == 2) {
            return 1;
        }

        return FibonacciA(cur - 1) + FibonacciA(cur - 2);
    }

    // 使用动态规划，使用O(n)空间复杂度
    private static int FibonacciB(int cur) {

        if (cur == 1 || cur == 2) {
            return 1;
        }

        int[] men = new int[cur];

        men[0] = 1;
        men[1] = 1;

        for (int i = 2; i < cur; i++) {
            men[i] = men[i - 1] + men[i - 2];
        }

        return men[cur - 1];
    }

    // 使用动态规划，使用O(n)空间复杂度
    private static int FibonacciC(int cur) {

        if (cur == 1 || cur == 2) {
            return 1;
        }

        int fast = 1;
        int slow = 1;

        for (int i = 2; i < cur; i++) {
            int temp = fast + slow;
            slow = fast;
            fast = temp;
        }

        return fast;
    }
}
