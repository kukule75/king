package sort;

/**
 * @author YuXiaodan
 * @ClassName FirstK
 * @Description 无序数组中查询第K大元素
 * @date 2019年09月10日 2019/9/10
 */
public class FirstK {

	public static void main(String[] args) {

		int[] a = {13,4,21,7,25,10,11,45,9};
		int res = topK(a, 0, a.length - 1, 3);

		System.out.println(res);
	}

	public static int topK(int[] a, int left, int right, int k){

		int i = left;
		int j = right;
		int pivot = a[left];

		while (i < j) {
			while (a[j] >= pivot && i < j){
				j--;
			}
			while (a[i] <= pivot && i < j){
				i++;
			}
			if (i < j) {
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			}
		}

		a[left] = a[i];
		a[i] = pivot;

		if ((i + 1) == k){
			return i;
		}else if ((i + 1) < k) {
			topK(a, i + 1, right, k);
		} else {
			topK(a, left, i - 1, k);
		}

		return a[a.length - k - 1];//topK
//		return a[k - 1];//buttonK
	}
}
