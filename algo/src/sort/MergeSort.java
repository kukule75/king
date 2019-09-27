package sort;

import java.util.Arrays;

/**
 * @author kinden
 *
 * 归并排序
 */
public class MergeSort {

    public static void main(String[] args) {

        int[] b = {78,27,21,34,3,23,12,25,22};

        mergeSort(b, 0, b.length - 1);

        Arrays.stream(b).forEach(System.out::println);
    }

    private static void mergeSort(int[] a, int right, int left){

        if (right >= left) {
            return;
        }

        int mid = right + ((left - right) >> 1);

        mergeSort(a, right, mid);
        mergeSort(a, mid + 1, left);

        merge(a, right, mid, left);
    }

    /**
     * 合并数组src[p,q]与src[q+1,r]，非原地算法，需要通过辅助数组temp完成
     * @param src 原数组
     * @param p
     * @param q
     * @param r
     */
    private static void merge(int[] src, int p, int q, int r) {

        int indexA = p;
        int indexB = q + 1;
        int indexTemp = 0;
        int[] temp = new int[r - p + 1];//归并排序是非原地排序

        System.out.println("merge src[" + p + "," + q + "] and src[" + (q+1) + "," + r + "]");

        while (indexA <= q && indexB <= r) {
            if (src[indexA] <= src[indexB]) {//保证归并排序的稳定性
                temp[indexTemp++] = src[indexA++];
            } else {
                temp[indexTemp++] = src[indexB++];
            }
        }

        for (int i = indexA; i <= q; i++) {
            temp[indexTemp++] = src[i];
        }

        for (int i = indexB; i <= r; i++) {
            temp[indexTemp++] = src[i];
        }

        for (int i = 0; i < r - p + 1; i++) {
            src[p+i] = temp[i];
        }
    }
}
