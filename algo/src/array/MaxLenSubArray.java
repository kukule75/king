package array;

/**
 * @author kinden
 * 查找指定长度的最大和子数组
 * 思路：
 * 1.双重循环暴力求解，时间复杂度是N*N
 * 2.遍历数组，比对每个x元祖的大小（类似于滑动窗口，减去上一个窗口的第一个元素，并加上下一个窗口的最后一个元素），
 *      记录可能的最大值，时间复杂度为N
 */
public class MaxLenSubArray {

    private static int[] array = {1,6,9,12,0,3,8,5,56,-23,32,50};

    public static void main(String[] args) {

        System.out.println(max(12));
        System.out.println(maxA(12));
    }

    private static int maxA(int x) {

        int len = array.length;

        if (x <= 0 || x > len) {
            return -1;
        }

        //最大和子数组下标
        int index = 0;
        //当前子数组累计和
        int curSum = 0;
        //子数组最大和
        int maxSum = 0;
        int temp = 0;
        for (int i = 0; i < x; i++) {
            curSum += array[i];
        }

        for (int i = x; i < len; i++) {
            temp = curSum - array[i - x] + array[x];
            if (temp > curSum) {
                maxSum = temp;
                index = i - x + 1;
            }
        }

        return index;
    }

    private static int max(int x){

        int len = array.length;

        if (x <= 0 || x > len) {
            return -1;
        }

        int index = 0;
        int temp = 0;
        for (int i = 0; i < len; i++) {
            int sum = 0;
            for (int j = i; (j < i + x) && (j < len); j++) {
                sum += array[j];
            }
            if (sum > temp) {
                temp = sum;
                index = i;
            }
        }

        return index;
    }
}
