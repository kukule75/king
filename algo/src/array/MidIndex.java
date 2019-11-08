package array;

/**
 * @author kinden
 *
 * 给定一个整数类型的数组 nums，请编写一个能够返回数组“中心索引”的方法。
 * 我们是这样定义数组中心索引的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
 * 如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。
 * nums = [1, 7, 3, 6, 5, 6], 索引3 (nums[3] = 6) 的左侧数之和(1 + 7 + 3 = 11)，与右侧数之和(5 + 6 = 11)相等。
 * 同时, 3 也是第一个符合要求的中心索引。
 * nums = [-1, -1, -1, 0, 1, 1] 返回0
 * nums = [-1, -1, 0, 1, 1, 0] 返回5
 */
public class MidIndex {

    public static void main(String[] args) {

        int[] a = {1, 7, 3, 6, 5, 6};
//        int[] a = {-1,-1,-1,0,1,1};
//        int[] a = {-1,-1,0,1,1,0};

        System.out.println(midIndex(a));
    }

    private static int midIndex(int[] a) {

        int len = a.length;

        int leftSum = 0;
        int rightSum = 0;

        for(int i = 1; i < len; i++) {
            rightSum += a[i];
        }

        for (int i = 0; i < len - 1; i++) {
            if (leftSum == rightSum) {
                return i;
            }
            leftSum += a[i];
            rightSum -= a[i + 1];
        }

        if (leftSum == rightSum) {
            return len - 1;
        }

        return -1;
    }

}
