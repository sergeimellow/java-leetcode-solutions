//https://leetcode.com/problems/min-stack/
//Runtime: 9 ms, faster than 42.72% of Java online submissions for Min Stack.
//Memory Usage: 48.5 MB, less than 44.72% of Java online submissions for Min Stack.

import java.util.Stack;

public class Leet0155 {
    private Stack<Integer> minStack;
    private Stack<Integer> mainStack;
    public static void main(String[] args) {
        // MinStack
        Leet0155 obj = new Leet0155();
//        ["MinStack","push","push","push","push","pop","getMin","pop","getMin","pop","getMin"]
//[[],[512],[-1024],[-1024],[512],[],[],[],[],[],[]]
        obj.push(512);
        obj.push(-1024);
        obj.push(-1024);
        obj.push(512);
        int min1 = obj.getMin();
        obj.pop();
        int min2 = obj.getMin();
        obj.pop();
        int min3 = obj.getMin();
        obj.pop();
        int min4 = obj.getMin();


        String a = "abc";
    }


    public Leet0155() {
        minStack = new Stack<>();
        mainStack = new Stack<>();

    }

    public void push(int val) {
        mainStack.push(val);
        if (minStack.size() == 0)
        {
            minStack.push(val);
        }
        else
        {
            minStack.push(Math.min(minStack.get(minStack.size() -1), val));
        }
    }

    public void pop() {
        minStack.pop();
        mainStack.pop();
    }

    public int top() {
        return mainStack.get(mainStack.size() - 1);
    }

    public int getMin() {
        return minStack.get(minStack.size()-1);
    }
}
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */