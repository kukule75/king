package binarySearch;

/**
 * @author YuXiaodan
 * @ClassName BinarySearchD
 * @Description 查找最后一个小于等于给定值的元素
 * @date 2019年09月10日 2019/9/10
 */
public class BinarySearchD {

	public static void main(String[] args) {

		int[] array = {1,3,5,7,9,11,24,56,89,100};

		System.out.println(binarySearch2(array, 7));
	}

	//小于等于
	public static int binarySearch1(int[] array, int value){

		int low = 0;

		int high = array.length - 1;

		while (low <= high) {

			int mid = low + ((high - low) >> 1);

			if (array[mid] <= value) {
				if(mid == array.length - 1 || array[mid + 1] > value) {
					return mid;
				} else {
					low = mid + 1;
				}
			} else {
				high = mid - 1;
			}
		}

		return -1;
	}

	//小于
	public static int binarySearch2(int[] array, int value){

		int low = 0;

		int high = array.length - 1;

		while (low <= high) {

			int mid = low + ((high - low) >> 1);

			if (array[mid] < value) {
				if(mid == array.length - 1 || array[mid + 1] >= value) {
					return mid;
				} else {
					low = mid + 1;
				}
			} else {
				high = mid - 1;
			}
		}

		return -1;
	}
}
