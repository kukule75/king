package binarySearch;

/**
 * @author YuXiaodan
 * @ClassName BinarySearchTest
 * @Description
 * @date 2019年09月10日 2019/9/10
 */
public class BinarySearchTest {

	public static void main(String[] args) {
		//变种算法
		int[] array1 = {1,1,3,7,8,9,12,34,78,99,100,100};
		//直接二分查找
		int[] array2 = {1,2,5,9,10,34,56,78,98,100};

//		System.out.println("查找等于" + 100 + "的元素下标=" + binarySearch1(array2, 100));
//		System.out.println("查找第一个等于" + 101 + "的元素下标=" + binarySearch2(array1, 101));
//		System.out.println("查找第一个等于" + 100 + "的元素下标=" + binarySearch3(array1, 100));
//		System.out.println("查找最后一个等于" + 1 + "的元素下标=" + binarySearch4(array1, 1));
//		System.out.println("查找最后一个等于" + 100 + "的元素下标=" + binarySearch5(array1, 100));
//		System.out.println("查找第一个大于等于" + 1 + "的元素下标=" + binarySearch6(array1, 1));
//		System.out.println("查找第一个大于" + 1 + "的元素下标=" + binarySearch7(array1, 1));
		System.out.println("查找最后一个小于等于" + 1 + "的元素下标=" + binarySearch8(array1, 11));
	}

	//直接二分查找
	public static int binarySearch1(int[] array, int value) {

		int low = 0;
		int high = array.length - 1;

		while (low <= high){
			int mid = low + ((high - low) >> 1);
			if (array[mid] > value) {
				high = mid - 1;
			} else if (array[mid] < value) {
				low = mid + 1;
			} else {
				return mid;
			}
		}

		return -1;
	}

	//查找第一个等于给定值的元素
	public static int binarySearch2(int[] array, int value){

		int low = 0;
		int high = array.length - 1;
		int size = high;

		while (low <= high) {
			int mid = low + ((high - low) >> 1);
			if (array[mid] >= value) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}

		return (low < size && array[low] == value) ? low : -1;
	}

	//查找第一个等于给定值的元素
	public static int binarySearch3(int[] array, int value){

		int low = 0;
		int high = array.length - 1;
		int size = high;

		while (low <= high) {
			int mid = low + ((high - low) >> 1);
			if (array[mid] > value) {
				high = mid - 1;
			} else if (array[mid] < value){
				low = mid + 1;
			} else {
				if (mid == 0 || array[mid - 1] != value ) {
					return mid;
				} else {
					high = mid - 1;
				}
			}
		}

		return -1;
	}

	//查找最后一个等于给定值的元素下标
	public static int binarySearch4(int[] array, int value){

		int low = 0;
		int high = array.length - 1;

		while (low <= high) {
			int mid = low + ((high - low) >> 1);
			if (array[mid] <= value) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}

		if (high >= 0 &&array[high] == value) {
			return high;
		} else {
			return -1;
		}
	}

	//查找最后一个等于给定值的元素下标
	public static int binarySearch5(int[] array, int value){

		int low = 0;
		int high = array.length - 1;
		int size = high;

		while (low <= high) {
			int mid = low + ((high - low) >> 1);
			if (array[mid] < value) {
				low = mid + 1;
			} else if (array[mid] > value){
				high = mid - 1;
			} else {
				if ((mid == size) || array[mid + 1] != value) {
					return mid;
				} else {
					low = mid + 1;
				}
			}
		}

		return -1;
	}

	//查找第一个大于等于给定值的元素下标
	public static int binarySearch6(int[] array, int value) {

		int low = 0;
		int high = array.length - 1;

		while (low <= high) {
			int mid = low + ((high - low) >> 1);
			if (array[mid] >= value) {
				if (mid == 0 || array[mid - 1] < value) {
					return mid;
				} else {
					high = mid - 1;
				}
			} else {
				low = mid + 1;
			}
		}

		return -1;
	}

	//查找第一个大于给定值的元素下标
	public static int binarySearch7(int[] array, int value) {

		int low = 0;
		int high = array.length - 1;

		while (low <= high) {
			int mid = low + ((high - low) >> 1);
			if (array[mid] > value) {
				if (mid == 0 || array[mid - 1] <= value) {
					return mid;
				} else {
					high = mid - 1;
				}
			} else {
				low = mid + 1;
			}
		}

		return -1;
	}

	//查找最后一个小于等于给定值的元素下标
	public static int binarySearch8(int[] array, int value) {
		int low = 0;
		int high = array.length - 1;

		while (low <= high) {
			int mid = low + ((high - low) >> 1);
			if (array[mid] <= value) {
				if (mid == array.length - 1 || array[mid + 1] > value) {
					return mid;
				}else {
					low = mid + 1;
				}
			} else {
				high = mid - 1;
			}
		}

		return -1;
	}
}
