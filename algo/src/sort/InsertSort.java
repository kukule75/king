package sort;

import java.util.Arrays;

/**
 * @author YuXiaodan
 * @ClassName sort.InsertSort
 * @Description
 * @date 2019年09月03日 2019/9/3
 */
public class InsertSort {

	public static void main(String[] args) {
		int[] array = {9,8,7,6,5,4,3,2,1};

		insertSort(array);

		Arrays.stream(array).forEach(System.out::print);

	}

	public static void insertSort(int[] array) {

		int len = array.length;

		if (len <= 1){
			return;
		}

		for (int i = 1; i < len; ++i) {
			int value = array[i];
			int j = i - 1;
			for (; j >= 0 ; --j) {
				if(array[j] > value) {
					array[j + 1] = array[j];
				}else {
					break;
				}
			}
			array[j + 1] = value;
		}
	}
}
