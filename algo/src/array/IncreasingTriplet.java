package array;

/**
 * @author kinden
 * 给定一个未排序的数组，判断这个数组中是否存在长度为 3 的递增子序列。
 *
 * 如果存在这样的 i, j, k,  且满足 0 ≤ i < j < k ≤ n-1，
 * 使得 arr[i] < arr[j] < arr[k] ，返回 true ; 否则返回 false 。
 *
 * 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1) 。
 *
 * 输入: [1,2,3,4,5]
 * 输出: true
 *
 * 输入: [5,4,3,2,1]
 * 输出: false
 */
public class IncreasingTriplet {

    public static void main(String[] args) {
//[2,1,5,0,4,6]
        int[] nums = {2,1,5,0,4,6};

        System.out.println(increasingTriplet(nums));
    }

    //这种写法有瑕疵，因为不能保证条件i < j < k
    public static boolean increasingTriplet(int[] nums) {

        int one = Integer.MAX_VALUE;
        int two = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= one) {
                one = nums[i];
            } else if (nums[i] <= two) {
                two = nums[i];
            } else {
                return true;
            }
        }

        return false;
    }
}
