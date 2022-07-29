// https://leetcode.com/problems/longest-repeating-character-replacement/
// Runtime: 71 ms, faster than 16.53% of Java online submissions for Longest Repeating Character Replacement.
// Memory Usage: 42.1 MB, less than 92.53% of Java online submissions for Longest Repeating Character Replacement.
//
// You are given a string s and an integer k. You can choose any character of the string and change it to any
// other uppercase English character. You can perform this operation at most k times.
//
// Return the length of the longest substring containing the same letter you can get after performing the above operations.


import java.util.*;

// Notes: Sliding window problem. Start with two pointers both at index 0.

public class Leet0424 {
    public static void main(String[] args)
    {
        String s = "BABBCDEEE";
        int k = 1;
        System.out.println(characterReplacement(s,k));
    }

    public static int characterReplacement(String s, int k) {
        Map<Character, Integer> currentCharacterCounts = new HashMap<>();
        int maxWindowSize = 0;
        int leftPointer = 0;

        for (int rightPointer = 0; rightPointer < s.length(); rightPointer++)
        {
            currentCharacterCounts.put(s.charAt(rightPointer),  currentCharacterCounts.getOrDefault(s.charAt(rightPointer), 0) + 1);
            while ((rightPointer - leftPointer + 1) - Collections.max(currentCharacterCounts.values()) > k)
            {
                currentCharacterCounts.put(s.charAt(leftPointer), currentCharacterCounts.get(s.charAt(leftPointer)) - 1);
                leftPointer += 1;
            }
            maxWindowSize = Math.max(maxWindowSize, rightPointer - leftPointer + 1);
        }

        return maxWindowSize;
    }
}
