// https://leetcode.com/problems/encode-and-decode-strings/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leet0271 {

    public static void main(String[] args) {
        List<String> input = new ArrayList<>();
        input.add("aaaaaa");
        input.add("@@@@asdasd@@@@");
        input.add("123@#aaaaa");
        input.add("L:OL");
        String encodedString = encode(input);
        List<String> decodedInput = decode(encodedString);

        System.out.println(Arrays.equals(new List[]{input}, new List[]{decodedInput}));
    }

    /*
     * @param strs: a list of strings
     * @return: encodes a list of strings to a single string. All strings get the length of the string and an @ character
     * appended to separate the string length and the string itself.
     * Examples:
     *   ["str1", "abcde", "c"] -> "4@str15@abcde1@c"
     *   ["abc", "123", ""]     -> "3@abc@1230@"
     *   ["i", "like", "pie"]   -> "1@i@4like@3pie"
     */
    public static String encode(List<String> strs) {
        String ret = "";
        for (String str : strs) {
            ret = ret + str.length() + "@" + str;
        }

        return ret;
    }

    /*
     * @param str: A string
     * @return: decodes a single string to a list of strings.
     * 1. Read up to the next occurrence of @ and keep track of where you started from with currentStartIndexForWordLength
     * 2. once you get to @ take the substring of currentStartIndexForWordLength and current index to get the upcoming word length
     * 3. use length and the current index to get the word and insert into decoded strings
     * 4. append the length of the word to the current index
     * 5. update the currentStartIndexForWordLength the index after the wordset the start index of where the next count is being stored
     * 6. repeat steps 1-5 until currentIndex is equal or larger than the length of the string.
     * */
    public static List<String> decode(String str) {
        List<String> decodedStrings = new ArrayList<>();
        int currentIndex = 0;
        int currentStartIndexForWordLength = 0;
        int strLength = str.length();
        while (currentIndex < strLength) {
            char currentChar = str.charAt(currentIndex);
            if (currentChar == '@') {
                // grab the length of the word after the current @ sign
                int wordLen = Integer.parseInt(str.substring(currentStartIndexForWordLength, currentIndex));
                // grab the word itself and insert it into the decoded strings
                String word = str.substring(currentIndex + 1, currentIndex + 1 + wordLen);
                decodedStrings.add(word);

                // increment the current index by the length of the word that was just added to the decoded strings.
                currentIndex = currentIndex + wordLen;
                // set the start index of where the next count is being stored
                currentStartIndexForWordLength = currentIndex + 1;
            }
            currentIndex++;
        }

        return decodedStrings;
    }
}
