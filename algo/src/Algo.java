import java.util.Arrays;

/**
 * @author YuXiaodan
 * @ClassName Algo
 * @Description
 * 所有的0去左边，所有的1去右边
 * 条件low < high，是为了一边倒的情况发生，防止下标溢出
 * while (low < high)，不能写成low <= high，因为会死循环
 * @date 2019年09月10日 2019/9/10
 */
public class Algo {

	public static void main(String[] args) {
		int[] array = {0,1,0,0};

		int low = 0;
		int high = array.length - 1;
		while (low < high){//不能写等号，会死循环
			while (array[low] == 0 && low < high){
				low++;
			}
			while (array[high] == 1 && low < high){
				high--;
			}
			if (low < high) {//有时候会相同的，省去一次交换
				int temp = array[low];
				array[low] = array[high];
				array[high] = temp;
			}
		}

		Arrays.stream(array).forEach(System.out::print);
	}
}
