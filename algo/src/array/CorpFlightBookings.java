package array;

import java.util.Arrays;

// 差分数组应用
public class CorpFlightBookings {

    public static void main(String[] args) {

        int[][] bookings = {{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};

        int[] res = corpFlightBookings(bookings, 5);

        System.out.println(Arrays.toString(res));
    }

    public static int[] corpFlightBookings(int[][] bookings, int n) {

        // nums 初始化为全 0
        int[] nums = new int[n];
        // 构造差分解法
        Difference df = new Difference(nums);

        for (int[] booking : bookings) {
            // 注意转成数组索引要减一哦
            int i = booking[0] - 1;
            int j = booking[1] - 1;
            int val = booking[2];
            // 对区间 nums[i..j] 增加 val
            df.increment(i, j, val);
        }
        // 返回最终的结果数组
        return df.result();
    }

}
