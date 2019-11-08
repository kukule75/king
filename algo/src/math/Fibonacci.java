package math;

/**
 * @author kinden
 * 斐波那契数列递归实现,1,1,2,3,5,8
 * 1.不考虑子问题的重复计算
 * 2.考虑子问题的重复计算，使用缓存记录
 */
public class Fibonacci {

    final static int NONE = -1;

    public static void main(String[] args) {

        //不考虑重复计算
        System.out.println(fibonacci(4));
        //考虑重复计算
        System.out.println(fib(4));

    }

    //不考虑重复计算问题
    private static int fibonacci(int n) {

        if (n <= 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    //考虑重复计算问题
    private static int fib(int n) {

        int[] men = new int[n];
        for (int i = 0; i < men.length; i++) {
            men[i] = NONE;
        }
        return fibonacciMen(n, men);
    }

    private static int fibonacciMen(int n, int[] men) {

        if (n <= 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        if (men[n - 1] == NONE) {
            men[n - 1] = fibonacci(n - 1);
        }
        if (men[n - 2] == NONE) {
            men[n - 2] = fibonacci(n - 2);
        }

        return men[n - 1] + men[n - 2];
    }
}
