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
     * @return: encodes a list of strings to a single string.
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
     * @return: decodes a single string to a list of strings
     */
    public static List<String> decode(String str) {
        List<String> ret = new ArrayList<>();
        String currentString = "";
        int currentIndex = 0;
        int currentWordIndex = 0;
        int strLength = str.length();
        while (currentIndex < strLength) {
            char b = str.charAt(currentIndex);
            currentString = currentString + b;
            if (b == '@') {
                String wordLengthString = str.substring(currentWordIndex, currentIndex);
                int wordLen = Integer.parseInt(wordLengthString);
                String word = str.substring(currentIndex + 1, currentIndex + 1 + wordLen);
                ret.add(word);

                currentIndex = currentIndex + wordLen;
                currentWordIndex = currentIndex + 1;
                currentString = "";
            }
            currentIndex++;
        }

        return ret;
    }
}
