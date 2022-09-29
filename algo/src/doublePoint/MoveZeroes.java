package doublePoint;

public class MoveZeroes {

    public static void main(String[] args) {

        int[] nums = {0,1,0,3,12};

        moveZeroes(nums);

    }

    public static void moveZeroes(int[] nums) {

        int i = 0;
        int j = 0;

        while (j < nums.length) {
            if (nums[j] != 0) {
                nums[i] = nums[j];
                i++;
            }
            j++;
        }

        for (int k = i; k < nums.length; k++) {
            nums[k] = 0;
        }
    }
}
