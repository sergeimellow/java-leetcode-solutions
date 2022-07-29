// https://leetcode.com/problems/binary-search/submissions/
// Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Search.
// Memory Usage: 54.8 MB, less than 20.18% of Java online submissions for Binary Search.

// ^ LOL, leetcode stats are whacky, no way this is right.

public class Leet0704 {

    public static void main(String[] args) {

        int[] input = {1,1,1,1,1,1,1,1,1,1,2,3};
        System.out.println(search(input, 3));
    }

    public static int search(int[] nums, int target) {
        int leftPointer = 0;
        int rightPointer = nums.length - 1;
        int midPointer;
        while (leftPointer <= rightPointer)
        {
            // line below can overflow 2^31, do midPointer = leftPointer + ((rightPointer - leftPointer) / 2) to avoid overflow
            // midPointer = (leftPointer + rightPointer) / 2;
            midPointer = leftPointer + ((rightPointer - leftPointer) / 2);
            if (nums[midPointer] > target )
            {
                rightPointer = midPointer - 1;
            }
            else if (nums[midPointer] < target)
            {
                leftPointer = midPointer + 1;
            }
            else
            {
                return midPointer;
            }
        }
        return -1;
    }
}
