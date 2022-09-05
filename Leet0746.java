// https://leetcode.com/problems/min-cost-climbing-stairs/submissions/
public class Leet0746 {
    public static void main(String[] args) {
        int[] cost = {1,100,1,1,1,100,1,1,100,1};
//        int[] cost = {10,15,20};
//        int[] cost = {0,0,1,1};
//        int[] cost = {0,1,2,2};
//        int[] cost = {1, 4, 8, 2, 1, 3};
        System.out.println(minCostClimbingStairs(cost));
    }

    public static int minCostClimbingStairs(int[] cost) {
        int stairLen = cost.length;
        if (stairLen == 0 || stairLen == 1) return 0;

        int first = cost[0];
        int second = cost[1];
        if (stairLen == 2) return Math.min(first, second);
        int currentCost;

        for (int i=2; i<stairLen; i++) {
            currentCost = cost[i] + Math.min(first, second);
            first = second;
            second = currentCost;
        }
        return Math.min(first, second);
    }
}
