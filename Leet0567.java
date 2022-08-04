// https://leetcode.com/problems/permutation-in-string/submissions/
import java.util.HashMap;
import java.util.Map;

public class Leet0567 {


    public static void main(String[] args) {
        checkInclusion("ba", "123ab");
    }


    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int windowSize = s1.length();
        Map<Character, Integer> s1HashMap = new HashMap<>();
        Map<Character, Integer> s2HashMap = new HashMap<>();
        Character nextChar;
        Integer nextCharCount;
        Character prevChar;
        Integer prevCharCount;
        for (char s1Char : s1.toCharArray())
        {
            s1HashMap.merge(s1Char, 1, Integer::sum);
        }
        for (int i = 0; i < windowSize; i++)
        {
            s2HashMap.merge(s2.charAt(i), 1, Integer::sum);
        }

        for (int i = 0; i < s2.length() - windowSize; i++ )
        {
            if (s1HashMap.equals(s2HashMap))
            {
                return true;
            }
            // update s2 map by adding new char
            nextChar = s2.charAt(i + windowSize);
            nextCharCount = s2HashMap.get(nextChar);
            if (nextCharCount != null)
            {
                s2HashMap.put(nextChar, nextCharCount + 1);
            }
            else
            {
                s2HashMap.put(nextChar, 1);
            }
            // remove prev char from hashmap
            prevChar = s2.charAt(i);
            prevCharCount = s2HashMap.get(prevChar);
            if (prevCharCount != 1)
            {
                s2HashMap.put(prevChar, prevCharCount - 1);
            }
            else
            {
                s2HashMap.remove(prevChar);
            }
        }

        return s1HashMap.equals(s2HashMap);

    }
}