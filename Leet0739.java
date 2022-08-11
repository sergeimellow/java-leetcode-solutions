// https://leetcode.com/problems/daily-temperatures/submissions/
import java.util.Arrays;
import java.util.Stack;

public class Leet0739 {

    public static void main(String[] args) {
        int[] temps = {1,3,2,10,7,10};
        System.out.println(Arrays.toString(dailyTemperatures(temps)));
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < temperatures.length; i++){
            while( !stack.isEmpty() && temperatures[i] > temperatures[stack.peek()] ) {
                int j = stack.pop();
                res[j] = i - j;
            }
            stack.push(i);
        }

        return res;
    }
}
