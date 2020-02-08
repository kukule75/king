package recurse;

/**
 * @author kinden
 */
public class KthGrammar779 {

    public static void main(String[] args) {

        System.out.println(kthGrammar(4,5));
//        System.out.println(1^1);
    }

    // 0
    // 01
    // 0110
    // 01101001
    // 递归实现
    public static int kthGrammar(int N, int K) {

        if (N == 1) {
            return 0;
        }

        // K是奇数，需要取N-1层的(K+1)/2位，如果是1，就是1，如果是0就是0
        // 看是偶数，需要取N-1层的K/2位，如果是1，就是0，如果是0，就是1，可以用异或实现
        if ((K&1) == 1) {
            int e =  kthGrammar(N-1,(K+1)/2);
            return e^0;
        } else {
            int e = kthGrammar(N-1,K/2);
            return e^1;
        }

    }
}
