package array;

import java.util.Arrays;

/**
 * @author kinden
 *
 * 倒转数组
 */
public class Reverse {

    public static void main(String[] args) {

        int[] arr = {1,2,3,4};

        reverse(arr);

        Arrays.stream(arr).forEach(System.out::println);
    }

    private static void reverse(int[] arr) {

        int len = arr.length;
        int temp;

        for (int i = 0, j = len - 1; i <= j; i++, j--) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
