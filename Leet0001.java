// https://leetcode.com/problems/two-sum
// Runtime: 73 ms, faster than 32.27% of Java online submissions for Two Sum.
// Memory Usage: 45 MB, less than 63.98% of Java online submissions for Two Sum.

import java.util.Arrays;

class Leet0001 {

    public static void main(String[] args) {
        int[] input = {2,7,11,15};
        System.out.println(Arrays.toString(twoSum(input, 9)));
    }

    public static int[] twoSum(int[] nums, int target) {
        int numsLength = nums.length;

        for(int i = 0; i < numsLength; i++) {
            for(int j = i+1; j < numsLength; j++) {
                if(nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{};
    }
}