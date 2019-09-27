package dynamic;

/**
 * @author kinden
 * 有n个台阶，每次爬一个台阶或者爬两个台阶，问有多少种爬法
 * 思路：n个台阶的问题，我们用F(n)表示
 * 1.如果我们还差一步就爬完n个台阶，那么此时可能我们正处在n-1个台阶或者n-2个台阶
 *      用公式表达就是F(n) = F(n-1) + F(n-2)
 * 2.很明显F(1) = 1,F(2) = 2
 * 3.可以使用递归方式，也可以使用动态规划方式
 */
public class Stair {

    public static void main(String[] args) {

        System.out.println(stair(4));
        System.out.println(stair1(4));
    }

    //O(n)
    private static int stair(int n) {

        if(n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        int[] men = new int[n];
        men[0] = 1;
        men[1] = 2;

        int i = 2;
        for (; i < n; i++) {
            men[i] = men[i - 1] + men[i - 2];
        }

        return men[i - 1];
    }

    //O(1)
    private static int stair1(int n) {

        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        int a = 1;
        int b = 2;

        int sum = 0;
        for (int i = 2; i < n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }

        return sum;
    }
}
