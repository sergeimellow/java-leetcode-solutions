import java.util.Stack;

// https://leetcode.com/problems/decode-string/
public class Leet0394 {
    public static void main(String[] args) {
        System.out.println(decodeString("2[a3[c4[b]]]"));
        // acbbbbcbbbbcbbbbacbbbbcbbbbcbbbb
        // steps:
        // "2[a3[c4[b]]]" ->
        // 1: acbbbbcbbbbcbbbb
        // 2: acbbbbcbbbbcbbbb
        // 3[c4[b]] -> 
        // 1: cbbbb
        // 2: cbbbb
        // 3: cbbbb
        // 4[b]
        // 1: bbbb
    }

    public static String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        int tempNum;
        int curNum = 0;
        StringBuilder curString = new StringBuilder();
        String prevString;
        Character curChar;
        for (int i = 0; i < s.length(); i++)
        {
            curChar = s.charAt(i);
            if (curChar == '[')
            {
                stack.push(curString.toString());
                stack.push(String.valueOf(curNum));
                curString = new StringBuilder();
                curNum = 0;
            }
            else if (curChar == ']')
            {
                tempNum = Integer.parseInt(stack.pop());
                prevString = stack.pop();
                curString = new StringBuilder(prevString + String.valueOf(curString).repeat(Math.max(0, tempNum)));

            }
            else if (Character.isDigit(curChar))
            {
                curNum = (curNum * 10) + Integer.parseInt(String.valueOf(curChar));
            }
            else
            {
                curString.append(curChar);
            }
        }

        return curString.toString();
    }
}
