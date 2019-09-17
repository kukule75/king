package sort;

import com.sun.javafx.logging.PulseLogger;

import java.util.Arrays;

/**
 * @author YuXiaodan
 * @ClassName sort.SelectSort
 * @Description
 * @date 2019年09月03日 2019/9/3
 */
public class SelectSort {

	public static void main(String[] args) {
		int[] array = {9,8,7,6,5,4,3,2,1};
		selectSort(array);
		Arrays.stream(array).forEach(System.out::print);
		
	}
	
	public static void selectSort(int[] array) {
		
		int len = array.length;
		
		if (len <= 1) {
			return;
		}

		for (int i = 0; i < len; i++) {

			int min_index = i;
			for (int j = i + 1; j < len; j++) {
				if(array[j] < array[min_index]) {
					min_index = j;
				}
			}

			if (min_index != i) {
				int temp = array[i];
				array[i] = array[min_index];
				array[min_index] = temp;
			}

		}
	}
}
