// https://leetcode.com/problems/product-of-array-except-self/
// Runtime: 4 ms, faster than 21.83% of Java online submissions for Product of Array Except Self.
// Memory Usage: 57.9 MB, less than 45.91% of Java online submissions for Product of Array Except Self.
import java.util.Arrays;

public class Leet0238 {

    public static void main(String[] args) {

        int[] input = {1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelf(input)));
    }

    public static int[] productExceptSelf(int[] nums) {
        int numsLength = nums.length;
        int[] answer = new int[numsLength];
        int[] prefix = new int[numsLength];
        int[] postfix = new int[numsLength];

        for (int i = 0; i < numsLength; i ++) {
            // handles populating the prefix array
            if (i==0) {
                prefix[i] = nums[i];
            }
            else {
                prefix[i] = prefix[i-1] * nums[i];
            }
            // handles populating the prefix array
            if (i==0) {
                postfix[numsLength - 1] = nums[numsLength - 1];
            }
            else {
                postfix[numsLength - i - 1] = postfix[numsLength - i] * nums[numsLength - i - 1];
            }
        }

        for (int i = 0; i < numsLength; i ++) {
            if (i == 0 )  {
                answer[i] = postfix[i+1];
            }
            else if (i == numsLength - 1)
            {
                answer[i] = prefix[i-1];
            }
            else {
                answer[i] = prefix[i-1] * postfix[i+1];
            }
        }

        // There is a more complicated way of doing this that still has a runtime of O(N) but a space complexity of O(1)
        // This involves only using the output array and not having a prefix/postfix arrays
        return answer;
    }
}
