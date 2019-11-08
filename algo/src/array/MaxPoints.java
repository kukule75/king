package array;

/**
 * @author kinden
 * 给定一个二维平面，平面上有 n 个点，求最多有多少个点在同一条直线上。
 * 输入: [[1,1],[2,2],[3,3]]
 * 输出: 3
 * 解释:
 * ^
 * |
 * |        o
 * |     o
 * |  o
 * +------------->
 * 0  1  2  3  4
 *
 * 输入: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * 输出: 4
 * 解释:
 * ^
 * |
 * |  o
 * |     o        o
 * |        o
 * |  o        o
 * +------------------->
 * 0  1  2  3  4  5  6
 */
public class MaxPoints {

    public static void main(String[] args) {

        int[][] points = {{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}};

        System.out.println(maxPoints(points));
    }

    public static int maxPoints(int[][] points) {

        return 0;
    }
}
