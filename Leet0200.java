// https://leetcode.com/problems/number-of-islands/submissions/
import java.util.*;

public class Leet0200 {
    public static void main(String[] args) {
        char[][] input = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}};
        System.out.println(numIslands(input));
    }
    public static int numIslands(char[][] grid) {
        int islandsCount = 0;
        int maxRows = grid.length;
        int maxCols = grid[0].length;
        Set<List<Integer>> visitedBefore = new HashSet<>();

        for(int row = 0; row < maxRows; row++)
        {
            for (int col = 0; col < maxCols; col++)
            {
                if (grid[row][col] == '1' && !visitedBefore.contains(Arrays.asList(row, col))) {
                    islandsCount += 1;
                    bfs(row, col, visitedBefore, maxRows, maxCols, grid);
                }
            }
        }

        return islandsCount;
    }

    // can be changed to iterative DFS by commenting out line 48 and uncommenting like 50
    private static void bfs(int row, int col, Set<List<Integer>> visitedBefore, int maxRows, int maxCols, char[][] grid) {
        Deque<List<Integer>> queue = new ArrayDeque<>();
        List<List<Integer>> directions = Arrays.asList(Arrays.asList(1, 0),Arrays.asList(-1, 0), // up / down
                                                       Arrays.asList(0, -1),Arrays.asList(0, 1)); // left / right
        List<Integer> rowCol = Arrays.asList(row, col);
        visitedBefore.add(rowCol);
        queue.add(rowCol);
        List<Integer> currentRowCol;
        List<Integer> currentRowColWithOffsets;
        int currentRowOffset;
        int currentColOffset;

        while (!queue.isEmpty()) {
            // BFS:
            currentRowCol = queue.remove();
            // non-recursive DFS:
            // currentRowCol = queue.removeLast();

            for (List<Integer> direction : directions) {
                currentRowOffset = currentRowCol.get(0)  + direction.get(0);
                currentColOffset = currentRowCol.get(1) + direction.get(1);
                currentRowColWithOffsets = Arrays.asList(currentRowOffset, currentColOffset);
                if (currentRowOffset >= 0 && currentColOffset >= 0 &&
                    currentRowOffset < maxRows && currentColOffset < maxCols &&
                    grid[currentRowOffset][currentColOffset] == '1' &&
                    !visitedBefore.contains(currentRowColWithOffsets))
                {
                    queue.add(currentRowColWithOffsets);
                    visitedBefore.add(currentRowColWithOffsets);
                }
            }
        }
    }
}
