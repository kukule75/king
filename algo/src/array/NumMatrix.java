package array;

public class NumMatrix {

    public static void main(String[] args) {

        int[][] nums = {{3,0,1,4,2}, {5,6,3,2,1}, {1,2,0,1,5}, {4,1,0,1,7}, {1,0,3,0,5}};

        NumMatrix matrix = new NumMatrix(nums);

        int i = matrix.sumRegion(1, 2, 2, 4);

        System.out.println(i);
    }

    private int[][] indices;

    public NumMatrix(int[][] matrix) {

        indices = new int[matrix.length][];

        for (int i = 0; i < matrix.length; i++) {
            int[] line = new int[matrix[i].length + 1];
            for (int j = 1; j <= matrix[i].length; j++) {
                line[j] = line[j-1] + matrix[i][j-1];
            }
            indices[i] = line;
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {

        int res = 0;
        for (int i = row1; i <= row2; i++) {
            res += (indices[i][col2 + 1] - indices[i][col1]);
        }

        return res;
    }
}
