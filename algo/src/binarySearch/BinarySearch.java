package binarySearch;

/**
 * @author YuXiaodan
 * @ClassName binarySearch.BinarySearch
 * @Description
 * @date 2019年09月10日 2019/9/10
 */
public class BinarySearch {

	public static void main(String[] args) {

		int[] array = {1,2,3,23,26,33,37,45,49,51,56,60,64,72,78,83,88,97,100};

		System.out.println(binarySearch(array, 34));
	}

	private static boolean binarySearch(int[] array, int value) {

		int low = 0;

		int high = array.length - 1;//1

		while (low <= high) {

//			int mid = (low + high) >> 1;
			int mid = low + ((high - low) >> 1);//2
			if (array[mid] > value) {
				high = mid - 1;//3
			} else if (array[mid] < value) {
				low = mid + 1;
			} else {
				return true;
			}
		}

		return false;
	}
}
