package sort;

import java.util.Arrays;

/**
 * @author YuXiaodan
 * @ClassName sort.BubbleSort
 * @Description
 * @date 2019年09月03日 2019/9/3
 */
public class BubbleSort {

	public static void main(String[] args) {
		int[] array = {9,2,8,1,7,6,5,4};
		bubbleSort(array);
		Arrays.stream(array).forEach(System.out::print);
	}

	public static void bubbleSort(int[] array) {

		int len = array.length;
		if (len <= 1) {
			return;
		}
		for (int i = 0; i < len; i++) {
			boolean flag = false;
			for (int j = 0; j < len - i - 1; ++j) {
				if(array[j] > array[j+1]) {
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
					flag = true;
				}
			}

			if (!flag) {
				break;
			}
		}
	}

}
