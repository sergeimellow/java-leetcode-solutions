// https://leetcode.com/problems/group-anagrams
// Runtime: 6 ms, faster than 99.46% of Java online submissions for Group Anagrams.
// Memory Usage: 45.4 MB, less than 94.00% of Java online submissions for Group Anagrams.

import java.util.*;

class Leet0049 {

	public static void main(String[] args) {
		String[] input = {"eat","tea","tan","ate","nat","bat"};
		System.out.println(groupAnagrams(input));
    }

    static public List<List<String>> groupAnagrams(String[] strs) {

		Map<String, List<String>> anagramsGroupBySortedAnagram = new HashMap<>();

		for (String currentString : strs) {
			char[] sCharArray = currentString.toCharArray();
			Arrays.sort(sCharArray);
			String currentStringSorted = new String(sCharArray);

			List<String> anagramGroup = anagramsGroupBySortedAnagram.getOrDefault(currentStringSorted, null);

			if (anagramGroup == null) {
				List<String> newAnagramGroup = new ArrayList<>();
				newAnagramGroup.add(currentString);
				anagramsGroupBySortedAnagram.put(currentStringSorted, newAnagramGroup);
			} else {
				anagramGroup.add(currentString);
			}

		}

		return new ArrayList<>(anagramsGroupBySortedAnagram.values());
	}
}