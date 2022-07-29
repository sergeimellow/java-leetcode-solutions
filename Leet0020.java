// https://leetcode.com/problems/valid-parentheses/
// Runtime: 4 ms, faster than 31.92% of Java online submissions for Valid Parentheses.
// Memory Usage: 42.3 MB, less than 24.50% of Java online submissions for Valid Parentheses.

//Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//
//An input string is valid if:
//
//Open brackets must be closed by the same type of brackets.
//Open brackets must be closed in the correct order.

import java.util.Map;
import java.util.Stack;

public class Leet0020 {
    public static void main(String[] args) {

        System.out.println(isValid("[][][]{{}}()(()}"));
    }


    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> closingTagByOpenTag = Map.of(')', '(','}','{',']','[');

        for (int i = 0; i<s.length(); i++)
        {
            char currentCharacter = s.charAt(i);
            if (closingTagByOpenTag.containsKey(currentCharacter)) {
                if (!stack.isEmpty() && stack.peek() == closingTagByOpenTag.get(currentCharacter)) {
                    stack.pop();
                }
                else {
                    return false;
                }
            }
            else
            {
                stack.push(currentCharacter);
            }
        }

        return stack.isEmpty();

    }
}
