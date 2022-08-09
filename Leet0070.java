// https://leetcode.com/problems/climbing-stairs/submissions/

public class Leet0070 {
    public static void main(String[] args) {
        System.out.println(climbStairs(5));
    }

    // after analysis turned out just being a fib problem.
    public static int climbStairs(int n) {
        int i = 1;
        int j = 1;
        int tempValue;
        while (n - 1 != 0)
        {
            n--;
            tempValue = i;
            i = j + i;
            j = tempValue;
        }
        return i;
    }
}
