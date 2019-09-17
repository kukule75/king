package binarySearch;

/**
 * @author YuXiaodan
 * @ClassName BinarySearchC
 * @Description 查找第一个大于等于、大于给定值的元素
 * @date 2019年09月10日 2019/9/10
 */
public class BinarySearchC {

	public static void main(String[] args) {
		int[] array = {1,3,5,7,9,11,24,56,89,100};

		System.out.println(binarySearch3(array, -1));
	}

	public static int binarySearch1(int[] array, int value){

		int low = 0;

		int high = array.length - 1;

		while (low <= high) {

			int mid = low + ((high - low) >> 1);

			if(array[mid] < value) {
				low = mid + 1;
			} else if (array[mid] > value) {
				high = mid - 1;
			} else {
				if (mid >= array.length - 1) {
					return -1;
				} else if (array[mid + 1] > value) {
					return mid + 1;
				} else {
					low = mid + 1;
				}
			}
		}

		if (low <= array.length - 1) {
			return low;
		} else {
			return -1;
		}

	}

	//大于等于
	public static int binarySearch2(int[] array, int value){

		int low = 0;

		int high = array.length - 1;

		while (low <= high) {

			int mid = low + ((high - low) >> 1);

			if(array[mid] < value) {
				low = mid + 1;
			} else {
				if (mid == 0 || array[mid - 1] < value) {
					return mid;
				} else {
					high = mid - 1;
				}
			}
		}

		return -1;
	}

	//大于
	public static int binarySearch3(int[] array, int value){

		int low = 0;

		int high = array.length - 1;

		while (low <= high) {

			int mid = low + ((high - low) >> 1);

			if(array[mid] <= value) {
				low = mid + 1;
			} else {
				if (mid == 0 || array[mid - 1] <= value) {
					return mid;
				} else {
					high = mid - 1;
				}
			}
		}

		return -1;
	}
}
