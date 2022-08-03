// https://leetcode.com/problems/number-of-1-bits/submissions/
// https://leetcode.com/submissions/detail/763738728/
public class Leet0191 {
    public static void main(String[] args) {
        int result = hammingWeight(22);
        String abc = "123";
    }

    public static int hammingWeight(int n) {
        // return Integer.bitCount(n);
        int numOfOnes = 0;
        for(int i=0; i< 32 ; i++){
            numOfOnes = numOfOnes + (n&1);
            n=n>>1;
            // actually slow things down...
            // if (n == 0)
            // {
                // break;
            // }
        }
        return numOfOnes;
        // Follow up: If this function is called many times, how would you optimize it? memoization/cache
    }

}
