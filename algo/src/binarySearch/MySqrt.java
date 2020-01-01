package binarySearch;

/**
 * @author kinden
 *
 * 实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 */
public class MySqrt {

    public static void main(String[] args) {

        System.out.println(mySqrt(10));
    }

    public static int mySqrt(int x) {

        int low = 1;
        int high = x;

        while (low <= high) {
            int mid = (low + high) >> 1;
            int plus = mid * mid;
            if (plus < x) {
                low = mid + 1;
            } else if (plus > x) {
                high = mid - 1;
            } else {
                return mid;
            }
        }

        return high;
    }
}
