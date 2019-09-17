package binarySearch;

/**
 * @author YuXiaodan
 * @ClassName BinarySearchA
 * @Description 查找第一个给定值的元素
 * @date 2019年09月10日 2019/9/10
 */
public class BinarySearchA {

	public static void main(String[] args) {

		int[] array = {1,1,3,23,26,33,37,45,49,49,49,60,64,72,78,83,88,97,100};

		System.out.println(binarySearch1(array, 1));
	}

	private static int binarySearch1(int[] array, int value) {

		int low = 0;

		int high = array.length - 1;//1

		while (low <= high) {

			int mid = low + ((high - low) >> 1);//2
			if (array[mid] > value) {
				high = mid - 1;//3
			} else if (array[mid] < value) {
				low = mid + 1;
			} else {
//				return mid;
				for(int i = mid - 1; i >= 0 ; --i) {
					if (array[i] != value) {
						return i + 1;
					}
				}
				return 0;
			}
		}

		return -1;
	}

	private static int binarySearch2(int[] array, int value) {

		int low = 0;

		int high = array.length - 1;//1

		while (low <= high) {

			int mid = low + ((high - low) >> 1);//2
			if (array[mid] > value) {
				high = mid - 1;//3
			} else if (array[mid] < value) {
				low = mid + 1;
			} else {
				if(mid == 0 || array[mid - 1] != value) {
					return mid;
				} else {
					high = mid - 1;
				}
			}
		}

		return -1;
	}

	private static int binarySearch3(int[] array, int value) {

		int low = 0;

		int high = array.length - 1;//1

		while (low <= high) {

			int mid = low + ((high - low) >> 1);//2
			if (array[mid] >= value) {
				high = mid - 1;//3
			} else if (array[mid] < value) {
				low = mid + 1;
			}
		}

		if (low < array.length && array[low] == value) {//为什么low < array.length
			return low;
		} else {
			return -1;
		}

	}
}
