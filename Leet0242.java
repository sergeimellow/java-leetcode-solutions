// https://leetcode.com/problems/valid-anagram/
// Runtime: 6 ms, faster than 63.45% of Java online submissions for Valid Anagram.
// Memory Usage: 45.2 MB, less than 32.18% of Java online submissions for Valid Anagram.

import java.util.Arrays;

class Leet0242 {

    public static void main(String[] args) {
        String s1 = "anagram";
        String s2 = "nagaram";
        System.out.println(isAnagram(s1, s2));
    }

    static public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
        {
            return false;
        }

        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();
        Arrays.sort(sCharArray);
        Arrays.sort(tCharArray);
        for (int i = 0; i < sCharArray.length; i++)
        {
            if (sCharArray[i] != tCharArray[i])
            {
                return false;
            }
        }
        
        return true;
    }
}