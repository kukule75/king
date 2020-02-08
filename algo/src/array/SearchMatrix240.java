package array;

import com.sun.xml.internal.fastinfoset.algorithm.BooleanEncodingAlgorithm;

/**
 * @author kinden
 */
public class SearchMatrix240 {

    public static void main(String[] args) {


        int[][] matrix = {
                            {1, 4, 7, 11, 15},
                            {2, 5, 8, 12, 19},
                            {3, 6, 9, 16, 22},
                            {10,13,14,17, 24},
                            {18,21,23,26, 30}
                        };

//        int[][] matrix = {{}};


        System.out.println(searchMatrix(matrix, 16));
        System.out.println(searchMatrixC(matrix, 16));
    }

    // O(m+n)
    public static boolean searchMatrixC(int[][] matrix, int target) {

        int row = matrix.length - 1;
        int col = 0;
        while (row >= 0 && col < matrix[0].length) {
            if (matrix[row][col] > target) {
                row--;
            } else if (matrix[row][col] < target) {
                col++;
            } else {
                return true;
            }
        }

        return false;
    }

    // 0.暴力
    public static boolean searchMatrixA(int[][] matrix, int target) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }

        return false;
    }
    
    // 1.暴力，最坏复杂度O(n*m)
    public static boolean searchMatrix(int[][] matrix, int target) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] > target) {
                    break;
                } else if(matrix[i][j] == target){
                    return true;
                }
            }
        }

        return false;

    }

    // 2.使用二分查找， O(min(M,N)(logM+logN))
    public static boolean searchMatrixB(int[][] matrix, int target) {
        // TODO
        return false;
    }
}
