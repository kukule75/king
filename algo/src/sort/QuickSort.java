package sort;

import java.lang.reflect.WildcardType;
import java.util.Arrays;

/**
 * @author YuXiaodan
 * @ClassName QuickSort
 * @Description
 * @date 2019年09月10日 2019/9/10
 */
public class QuickSort {

	public static void main(String[] args) {
		int[] array = {0,8,7,6,5,9,3,2,1,4};

		quickSort1(0, array.length - 1, array);

		Arrays.stream(array).forEach(System.out::print);
	}

	public static void a(int left, int right, int[] arr) {

		int pivot = arr[left];

		int i = left;
		int j = right;

		while (i < j) {
			while (arr[j] >= pivot && i < j) {
				j--;
			}
			while (arr[i] >= pivot && i < j) {
				i++;
			}

			if (i < j) {
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}
		}

		arr[left] = arr[i];
		arr[i] = pivot;

		a(left, i - 1, arr);
		a(i + 1, right, arr);
	}

	//交换法，已最左为支点
	//参考https://wiki.jikexueyuan.com/project/easy-learn-algorithm/fast-sort.html
	public static void quickSort(int left, int right, int[] array){

		if (left >= right) {
			return;
		}

		int i = left;
		int j = right;

		int pivot = array[i];

		while (i < j) {
			while (array[j] >= pivot && i < j){
				j--;
			}
			while (array[i] <= pivot && i < j){
				i++;
			}
			if (i < j) {
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}

		array[left] = array[i];
		array[i] = pivot;

		quickSort(left, i - 1, array);
		quickSort(i + 1, right, array);
	}

	//交换法，已最右为支点
	public static void quickSort1(int left, int right, int[] a){

		if(left >= right) {
			return;
		}

		int pivot = a[right];
		int i = left;
		int j = right;

		while (i < j) {
			while (a[i] <= pivot && i < j){
				i++;
			}
			while (a[j] >= pivot && i < j){
				j--;
			}

			if(i < j) {
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			}
		}

		a[right] = a[j];
		a[j] = pivot;

		quickSort1(left, j - 1, a);
		quickSort1(j + 1, right, a);
	}
}
