// https://leetcode.com/problems/generate-parentheses/

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leet0022 {
    public static void main(String[] args) {
        generateParenthesis(3);
    }
    
    public static List<String> generateParenthesis(int n) {
        ArrayList<String> ret = new ArrayList<>();
        Stack<Character> stack = new Stack<>();
        // algo:
        // only add open paren if open < n
        // only add close paren if closed < open
        // if open == close && closed = n then add valid parens to ret
        backtrack(n, 0, 0, stack, ret);
        return ret;
    }

    public static void backtrack(int n, int openParen, int closeParen, Stack<Character> stack, ArrayList<String> ret)
    {
        // if open == close && closed = n add to ret
        if (openParen == closeParen && closeParen == n)
        {
            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < stack.size(); i++)
            {
                sb.append(stack.get(i));
            }
            ret.add(sb.toString());
            return;
        }

        // only add open paren if open < n
        if (openParen < n)
        {
            stack.add('(');
            backtrack(n, openParen + 1, closeParen, stack, ret);
            stack.pop();
        }

        // only add close paren if closed < open
        if (closeParen < openParen)
        {
            stack.add(')');
            backtrack(n, openParen, closeParen + 1, stack, ret);
            stack.pop();
        }
    }
}
