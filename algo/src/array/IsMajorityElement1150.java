package array;

/**
 * @author kinden
 */
public class IsMajorityElement1150 {

    public static void main(String[] args) {

        int[] nums = {2,4,5,5,5,5,5,6,6};

        System.out.println(isMajorityElement(nums, 5));
    }

    public static boolean isMajorityElement(int[] nums, int target) {

        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                count++;
            }
        }

        return count > (nums.length/2);
    }
}
