import java.io.FileWriter;

/**
 * @author YuXiaodan
 * @ClassName Fuck
 * @Description
 * @date 2019年08月23日 2019/8/23
 */
public class Fuck {

	private static FileWriter fileWriter;

	public static void main(String[] args) throws InterruptedException {

//		BoundedBlockingQueue1188 queue = new BoundedBlockingQueue1188(3);
//		queue.enqueue(1);
//		System.out.println(queue.dequeue());

//		int[][] nums = {
//				{ 1, 2, 3, 4},
//				{ 5, 6, 7, 8},
//				{ 9,10,11,12},
//				{13,14,15,16}
//		};
//
//		for (int i = 2; i <= nums.length; i++) {
//			for (int j = 0; j <= nums.length - i; j++) {
//				int k = i + j - 1;
//				System.out.println(nums[j][k]);
//			}
//		}

		int[] nums = {-2, 0, 3, -5, 2, -1};
		int[] preSum;

		preSum = new int[nums.length + 1];
		// 计算 nums 的累加和
		for (int i = 1; i < preSum.length; i++) {
			preSum[i] = preSum[i - 1] + nums[i - 1];
		}

	}
}
