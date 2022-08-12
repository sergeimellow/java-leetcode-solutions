// https://leetcode.com/problems/evaluate-reverse-polish-notation/

import java.util.Stack;

public class Leet0150 {
    public static void main(String[] args) {
        String[] a = {"4","-2","/","2","-3","-","-"};
        evalRPN(a);
    }
    // "2","1","+","3","*"
    public static  int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        int numOne;
        int numTwo;

        for(String token : tokens) {
            if ("/".equals(token)) {
                numTwo = Integer.parseInt(stack.pop());
                numOne = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(numOne / numTwo));
            }
            else if ("+".equals(token)) {
                numTwo = Integer.parseInt(stack.pop());
                numOne = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(numOne + numTwo));
            }
            else if ("*".equals(token)) {
                numTwo = Integer.parseInt(stack.pop());
                numOne = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(numOne * numTwo));
            }
            else if ("-".equals(token)) {
                numTwo = Integer.parseInt(stack.pop());
                numOne = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(numOne - numTwo));
            }
            else
            {
                stack.push(token);
            }
        }

        return Integer.parseInt(stack.pop());
    }
}
