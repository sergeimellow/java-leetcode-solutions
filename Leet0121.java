// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/submissions/
// Runtime: 3 ms, faster than 67.17% of Java online submissions for Best Time to Buy and Sell Stock.
// Memory Usage: 84.4 MB, less than 16.75% of Java online submissions for Best Time to Buy and Sell Stock.

public class Leet0121 {

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println("Returned:" + maxProfit(prices));
        System.out.println("Expected: 5");
    }

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int currentProfit;
        int leftPrice = 0;
        int rightPrice = 1;

        while (rightPrice < prices.length)
        {
            if (prices[leftPrice] < prices[rightPrice])
            {
                currentProfit = prices[rightPrice] - prices[leftPrice];
                maxProfit = Math.max(maxProfit, currentProfit);
            }
            else
            {
                leftPrice = rightPrice;
            }

            rightPrice += 1;
        }

        return maxProfit;
    }
}
