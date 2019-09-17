package binarySearch;

/**
 * @author YuXiaodan
 * @ClassName BinarySearchB
 * @Description 查找最后一个等于给定值的元素
 * @date 2019年09月10日 2019/9/10
 */
public class BinarySearchB {

	public static void main(String[] args) {

		int[] array = {1,1,3,23,26,33,37,45,49,49,49,60,64,72,78,83,88,100,100};

		System.out.println(binarySearch3(array, 100));
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
				for(int i = mid + 1; i <= array.length ; ++i) {
					if (i == array.length || array[i] != value) {
						return i - 1;
					}
				}
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
				if(mid == array.length - 1 || array[mid + 1] != value) {
					return mid;
				} else {
					low = mid + 1;
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
			if (array[mid] > value) {
				high = mid - 1;//3
			} else if (array[mid] <= value) {
				low = mid + 1;
			}
		}

		if (array[high] == value) {
			return high;
		} else {
			return -1;
		}

	}
}
