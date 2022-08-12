// https://leetcode.com/problems/max-area-of-island/

public class Leet0695
{
    public static void main(String[] args) {
        int[][] a = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
    maxAreaOfIsland(a);
    }
    public static  int maxAreaOfIsland(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        int area = 0;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                area = Math.max(area, dfs(r, c, grid, ROWS, COLS, new int[] { 0 }));
            }
        }
        return area;
    }


    public static int dfs (int r, int c, int[][] grid, int maxRows, int maxCols, int[] count)
    {
        if (r < 0 || r == maxRows ||
            c < 0 || c == maxCols ||
            grid[r][c] == 0) {
            return count[0];
        }
        count[0]++;
        grid[r][c] = 0;
        dfs(r - 1, c, grid, maxRows, maxCols, count);
        dfs(r + 1, c, grid, maxRows, maxCols, count);
        dfs(r, c - 1, grid, maxRows, maxCols, count);
        dfs(r, c + 1, grid, maxRows, maxCols, count);

        return count[0];

    }
}
