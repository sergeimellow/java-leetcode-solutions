// https://leetcode.com/problems/unique-paths/
public class Leet0062 {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3 ,7));
    }

    public static int uniquePaths(int m, int n) {
        int[][] arr = new int[m][n];

        for (int i = m - 1; i >= 0; i--)
        {
            for (int j = n - 1; j >= 0; j--)
            {
                if (i == m - 1)
                {
                    arr[i][j] = 1;
                    continue;
                }
                if (j == n - 1)
                {
                    arr[i][j] = 1;
                    continue;
                }
                arr[i][j] = arr[i][j+1] + arr[i+1][j];
            }
        }

        return arr[0][0];
    }

}
