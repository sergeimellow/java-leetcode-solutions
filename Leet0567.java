// https://leetcode.com/problems/permutation-in-string/submissions/
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Leet0567 {


    public static void main(String[] args) {
        System.out.println(checkInclusionWithoutHashMapAndCaseSens("ba", "AZddabBAZaz"));
    }

    public static boolean checkInclusionWithoutHashMapAndCaseSens(String s1, String s2)
    {
        if (s1.length() > s2.length()) return false;
        int windowSize = s1.length();
        int[] s1Arr = new int[58];
        int[] s2Arr = new int[58];
        int matches = 0;

        // init arr1 & arr2
        for (int i = 0; i < windowSize; i++)
        {
            s1Arr[s1.charAt(i) - 'A'] += 1;
            s2Arr[s2.charAt(i) - 'A'] += 1;
        }

        for (int i = 0; i < 58; i++)
        {
            if (s1Arr[i] == s2Arr[i])
            {
                matches += 1;
            }
        }

        System.out.println(Arrays.toString(s1Arr));
        System.out.println(Arrays.toString(s2Arr));
        System.out.println(matches);

        int index;
        int leftPointer = 0;
        for (int i = windowSize; i<s2.length(); i++)
        {
            if (matches == 58)
            {
                return true;
            }
            // get the index of the current char, aka the right pointer
            index = s2.charAt(i) - 'A';
            // increment the count of the retrieved index in arr
            s2Arr[index] += 1;
            if (s1Arr[index] == s2Arr[index])
            {
                matches += 1;
            }
            else if (s1Arr[index] + 1 == s2Arr[index]) {
                matches -= 1;
            }

            // get the index of the current char
            index = s2.charAt(leftPointer) - 'A';
            // increment the count of the retrieved index in arr
            s2Arr[index] -= 1;
            if (s1Arr[index] == s2Arr[index])
            {
                matches += 1;
            }
            else if (s1Arr[index] - 1 == s2Arr[index]) {
                matches -= 1;
            }
            // slides the left pointer to the right
            leftPointer += 1;
        }

        return matches == 58;

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
