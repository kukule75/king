package array;

import java.util.Arrays;

/**
 * @author kinden
 *
 * 给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 *
 *  输出[1,2,4,7,5,3,6,8,9]
 */
public class FindDiagonalOrder {

    public static void main(String[] args) {
        int[][] a = {{1,2,3},{4,5,6},{7,8,9}};

        int[] arr = findDiagonalOrder(a);
        Arrays.stream(arr).forEach(System.out::println);
    }

    private static int[] findDiagonalOrder(int[][] a) {

        int lenA = a.length;
        if(lenA == 0) {
            System.out.println("none");
            return new int[0];
        }
        int lenB = a[0].length;

        int[] arr = new int[lenA*lenB];
        int idx = 0;
        int i = 0;
        int j = 0;

        while (i < lenA && j < lenB) {
            if (((i+j)&1) == 0) {//高效判断偶数
                while (i >= 0 && j < lenB) {
                    arr[idx++]=a[i--][j++];
                }
                i++;
                if (j >= lenB) {
                    i++;
                    j--;
                }
            } else {
                while (i < lenA && j >= 0) {
                    arr[idx++]=a[i++][j--];
                }
                j++;
                if (i >= lenA) {
                    j++;
                    i--;
                }
            }
        }

        return arr;
    }
}
