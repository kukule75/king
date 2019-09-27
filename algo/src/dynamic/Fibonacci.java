package dynamic;

/**
 * @author kinden
 *  1,1,2,3,5,8,13
 * 使用动态规划算法实现斐波那契数列实现
 */
public class Fibonacci {

    //1,1,2,3,5,8
    public static void main(String[] args) {

        System.out.println(fib(5));
        System.out.println(fib1(5));

    }

    //保存了所有中间,空间复杂度为O(n)
    private static int fib(int n) {

        int[] men = new int[n];

        men[0] = 1;
        men[1] = 1;

        if (n == 1 || n == 2) {
            return 1;
        }

        int i = 2;
        for (; i < n; i++) {
            men[i] = men[i - 1] + men[i - 2];
        }

        return men[i - 1];
    }

    //其实可以只记录前面两个状态的值,空间复杂度为O(1)
    private static int fib1(int n) {

        int a = 1;
        int b = 1;

        if (n == 1 || n == 2) {
            return 1;
        }

        int sum = 0;
        for (int i = 2; i < n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }

        return sum;
    }

}
