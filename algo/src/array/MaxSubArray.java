package array;

/**
 * @author kinden
 * 最大和子数组
 * 思路：从数组头部开始扫描累加，得到累计和curSum
 * 1.一旦curSum小于0，那么累计和就清零，抛弃前面的子数组
 * 2.curSum不为0，需要记录每个可能的最大值
 */
public class MaxSubArray {

    private static int[] array = {-1,1,2,3,-1,4,-2,-3,4,7,8,-1};

    public static void main(String[] args) {
        System.out.println(maxSubArray1());
    }

    private static int maxSubArray1() {

        int len = array.length;

        int curSum = 0;
        int max = 0;
        for (int i = 0; i < len; i++) {
            curSum = (0 > curSum + array[i]) ? 0 : curSum + array[i];
            max = (curSum > max) ? curSum : max;
        }

        return max;
    }

    private static int maxSubArray2() {

        int len = array.length;

        int curSum = 0;
        int max = 0;
        for (int i = 0; i < len; i++) {
            curSum = (array[i] > array[i] + curSum) ? array[i] : array[i] + curSum;
            max = (curSum > max) ? curSum : max;
        }

        return max;
    }
}
