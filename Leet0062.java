import java.util.Arrays;

// https://leetcode.com/problems/unique-paths/
public class Leet0062 {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3 ,7));
    }

    public static int uniquePaths(int m, int n) {
        int[] curRow = new int[n];
        int[] nextRow;
        Arrays.fill(curRow, 1);
        for (int i = m - 2; i >= 0; i--)
        {
            nextRow = new int[n];
            for (int j = n - 1; j >= 0; j--)
            {
                if (j+1 != n)
                {
                    nextRow[j] = nextRow[j+1] + curRow[j];
                }
                else
                {
                    nextRow[j] = curRow[j];
                }
            }
            curRow = nextRow;
        }

        return curRow[0];
    }

}
