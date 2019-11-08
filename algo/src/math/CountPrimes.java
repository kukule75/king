package math;

import java.util.Arrays;

/**
 * @author kinden
 *
 * 统计所有小于非负整数 n 的质数的数量。
 *
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 */
public class CountPrimes {

    public static void main(String[] args) {

        System.out.println(countPrimesA(13));

    }


    public static int countPrimesA(int n) {

        boolean[] res = new boolean[n];

        Arrays.fill(res, true);

        int limit = (int)Math.sqrt(n);
        for (int i = 2; i <= limit; i++) {//第一层优化，只需要到limit
            if (res[i]) {//可以优化掉一点
                for (int j = i * i; j < n; j += i) {//第二层优化，使用i*i过滤掉重复的
                    res[j] = false;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (res[i]) {
                count++;
            }
        }

        return count;
    }

    //超时的写法
    public static int countPrimes(int n) {

        //需要返回的质数
        int res;
        //除数，从2开始递增直到res
        int divisor;
        //是否质数
        boolean flag;

        int count = 0;

        for(res = 2; res < n; res++) {
            flag = true;
            for(divisor = 2; divisor <= Math.sqrt(res); divisor++) {
                if(res % divisor == 0) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                count++;
            }
        }

        return count;
    }
}
