package BFS;

public class NumIslands {

    public static void main(String[] args) {

        char[][] grid = new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};

        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {

        boolean[][] islands = new boolean[grid.length][grid[0].length];

        int total = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1'){
                    total++;
                    visit(grid, i, j, islands);
                }
            }
        }

        return total;
    }

    public static void visit(char[][] grid, int i, int j, boolean[][] islands) {

        if ( i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return;
        }

        if (islands[i][j]) {
            return;
        }

        islands[i][j] = true;

        if (grid[i][j] == '0') {
            return;
        }
        // 当前陆地变为海水
        grid[i][j] = '0';
        // 淹没上线左右的陆地
        visit(grid, i, j - 1, islands);
        visit(grid, i, j + 1, islands);
        visit(grid, i - 1, j, islands);
        visit(grid, i + 1, j, islands);
    }
}
