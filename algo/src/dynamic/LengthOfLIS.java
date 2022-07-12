package dynamic;

public class LengthOfLIS {

    public static void main(String[] args) {

        int[] nums = {10,9,2,5,3,7,101,18};
        int i = lengthOfLIS(nums);
        System.out.println(i);
    }

    private static int lengthOfLIS(int[] nums) {

        int res = 0 ;
        int sentinel = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int cur = 0;
            sentinel = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (sentinel <= nums[j]) {
                    sentinel = nums[j];
                    cur++;
                }
            }
            res = Math.max(res, cur);
        }

        return res;

    }


}
