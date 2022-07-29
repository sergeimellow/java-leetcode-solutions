// https://leetcode.com/problems/longest-substring-without-repeating-characters/
// Runtime: 11 ms, faster than 64.55% of Java online submissions for Longest Substring Without Repeating Characters.
// Memory Usage: 46.5 MB, less than 23.01% of Java online submissions for Longest Substring Without Repeating Characters.

import java.util.HashSet;
import java.util.Set;

public class Leet0003 {
    public static void main(String[] args) {
        String input = "abcabcbb";
        System.out.println("Returned:" + lengthOfLongestSubstring(input));
        System.out.println("Expected: abc");
    }

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> currentCharSet = new HashSet<>();
        int currentSubStringLength = 0;
        int longestSubstring = 0;
        Character currentCharacter;

        for(int i = 0; i<s.length(); i++)
        {
            currentCharacter = s.charAt(i);
            while (currentCharSet.contains(currentCharacter)){
                currentCharSet.remove(s.charAt(currentSubStringLength));
                currentSubStringLength += 1;
            }

            currentCharSet.add(currentCharacter);
            longestSubstring = Math.max(longestSubstring, i - currentSubStringLength + 1);
        }

        return longestSubstring;
    }
}
