import java.util.*;

public class Leet0051 {
    public static void main(String[] args) {
        solveNQueens(4);
    }

    public static List<List<String>> solveNQueens(int n) {
        Set<Integer> col = new HashSet<>();
        Set<Integer> pd = new HashSet<>(); // r + c
        Set<Integer> nd = new HashSet<>(); // r - c
        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
        List<List<String>> res = new ArrayList<>();
        backtrack(0, col, pd, nd, board, res, n);
        return res;
    }

    public static void backtrack(int r, Set<Integer> col, Set<Integer> pd, Set<Integer> nd, char[][] board, List<List<String>> res, int n)
    {
        if (r == n)
        {
            StringBuilder copy;
            List<String> currentBoard = new ArrayList<>();
            for (int i = 0; i< board.length; i++)
            {
                copy = new StringBuilder();
                for (int j = 0; j < board.length; j++)
                {
                    copy.append(board[i][j]);
                }
                currentBoard.add(copy.toString());
            }
            res.add(currentBoard);
            return;
        }


        for (int c = 0; c<n; c++)
        {
            if(col.contains(c) || pd.contains(r+c) || nd.contains(r-c)){
                continue;
            }

            col.add(c);
            pd.add(r+c);
            nd.add(r-c);
            board[r][c] = 'Q';

            backtrack(r+1, col, pd, nd, board, res, n);

            col.remove(c);
            pd.remove(r+c);
            nd.remove(r-c);
            board[r][c] = '.';
        }
    }
}
