package array;

/**
 * @author kinden
 *
 * 给定一个数组和一个值，原地删除该值的所有实例并返回新的长度。
 */
public class RemoveElement {

    public static void main(String[] args) {

        int[] arr = {1,2,3,3,3,4,5,6,7};

        int k = removeElement(arr, 3);

        System.out.println(k);
    }

    private static int removeElement(int[] arr, int value) {

        int k = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != value) {
                arr[k] = arr[i];
                k++;
            }
        }

        return k;
    }
}
