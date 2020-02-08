package array;

/**
 * @author kinden
 *
 * 同240
 */
public class SearchMatrix74 {

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
}
