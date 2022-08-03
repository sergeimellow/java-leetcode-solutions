// https://leetcode.com/problems/single-number/
// https://leetcode.com/submissions/detail/763721975/
public class Leet0136 {
    public static void main(String[] args) {
        int[] a = {3,1, 4, 1, 2, 2, 3};
        int result = singleNumber(a);
        String abc = "123";

    }

    public static int singleNumber(int[] nums) {
        int ret = 0;
        for (int n : nums)
        {
            // fancy use of XOR, reminder of how this works:
            // false ^ false == false
            // true ^ false == true
            // false ^ true == true
            // true ^ true == false

            // O00000101 (5)
            // 000000010 (2)
            // =
            // 000000111 (7)
            // = 5 ^ 2

            ret = ret ^ n;
        }
        return ret;
    }
}
