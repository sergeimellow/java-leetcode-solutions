// https://leetcode.com/problems/longest-consecutive-sequence/submissions/
// Runtime: 15 ms, faster than 97.54% of Java online submissions for Longest Consecutive Sequence.
// Memory Usage: 64.3 MB, less than 76.46% of Java online submissions for Longest Consecutive Sequence.
// Notes: Sort the nums int array before doing stuff
// Example:
// 1,2,3, 44,55, 777,888,999,123
//  ->
// 1,2,3


import java.util.*;

public class Leet0128 {

    public static void main(String[] args) {
        int[] input = {0,0,-1};

        System.out.println(longestConsecutive(input));
        System.out.println("Expected: 3");
    }

    public static int longestConsecutive(int[] nums) {
        int numsLength = nums.length;
        if (numsLength == 0 )
        {
            return 0;
        }
        Arrays.sort(nums);
        int currentSequence=1;
        int currentLongestSequence=1;

        for(int i = 1; i < numsLength; i++)
        {
            int num = nums[i];
            if (num == nums[i-1])
            {
                continue;
            }
            else if (num == nums[i-1]+1)
            {
                currentSequence += 1;
            }
            else
            {
                if(currentSequence > currentLongestSequence)
                {
                    currentLongestSequence = currentSequence;
                }
                currentSequence = 1;
            }
        }

        if(currentSequence > currentLongestSequence)
        {
            currentLongestSequence = currentSequence;
        }

        return currentLongestSequence;
    }
}
