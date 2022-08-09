// https://leetcode.com/problems/contains-duplicate
// Runtime: 6 ms, faster than 96.83% of Java online submissions for Contains Duplicate.
// Memory Usage: 54.5 MB, less than 93.73% of Java online submissions for Contains Duplicate.

import java.util.HashMap;
import java.util.Map;

class Leet0217 {
    public static void main(String[] args) {
        int[] input = new int[]{-1,-1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        System.out.println(containsDuplicate(input));
    }

    public static boolean containsDuplicate(int[] nums) {
        Map<Integer, Boolean> hashSet =  new HashMap<>();
        for (int num : nums) {
            if (hashSet.get(num) != null) {
                return true;
            } else {
                hashSet.put(num, true);
            }
        }

        return false;
    }
}