package sort;

import java.util.Arrays;

/**
 * @author YuXiaodan
 * @ClassName SortTest
 * @Description
 * @date 2019年09月10日 2019/9/10
 */
public class SortArray {

	public static void main(String[] args) {

		int[] a = {9,8,7,1,5,4,3,2,6};
//		int[] a = {9,9,9,9,9,9};
//		bubbleSort(a);
//		insertSort(a);
//		selectSort(a);
		quickSort(a, 0, a.length - 1);
		Arrays.stream(a).forEach(System.out::print);
	}

	public static void quickSort(int[] a, int start, int end) {

		if (start >= end) {
			return;
		}

		int i = start;
		int j = end;
		int pivot = a[end];

		while (i < j) {
			while (i < j && a[i] <= pivot) {
				i++;
			}
			while (i < j && a[j] >= pivot) {
				j--;
			}

			if (i != j) {
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			}
		}

		a[end] = a[i];
		a[i] = pivot;

		quickSort(a, start, i - 1);
		quickSort(a, i + 1, end);
	}

	public static void bubbleSort(int[] a){

		for (int i = 0; i < a.length; i++) {
			boolean sign = false;
			for (int j = 0; j < a.length - 1 - i; j++) {//为什么还要减i，因为后面i位已经是有序了
				if (a[j] > a[j + 1]) {
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
					sign = true;
				}
				if (!sign) {
					break;
				}
			}
		}
	}

	public static void insertSort(int[] a){

		for (int i = 1; i < a.length; i++) {
			int value = a[i];
			int j = i;
			for (; j > 0 ; j--) {
				if(a[j - 1] > value) {
					a[j] = a[j - 1];
				} else {
					break;//可以节省一些循环操作
				}
			}
			a[j] = value;
		}
	}

	public static void selectSort(int[] a){

		for (int i = 0; i < a.length; i++) {
			int value = a[i];

			int j = i;
			int min_idx = j;
			for (; j < a.length; j++) {
				if(a[j] < value) {
					min_idx = j;
				}
			}

			if (min_idx != i) {
				int temp = a[min_idx];
				a[min_idx] = a[i];
				a[i] = temp;
			}

		}

	}
}
