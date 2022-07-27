// https://leetcode.com/problems/valid-palindrome
// Runtime: 16 ms, faster than 43.39% of Java online submissions for Valid Palindrome.
// Memory Usage: 43.4 MB, less than 76.20% of Java online submissions for Valid Palindrome.

class Leet0125 {
    public static void main(String[] args) {

        System.out.println(isPalindrome("aba"));
    }
            

    public static boolean isPalindrome(String s) {

        if (s.length() <= 1)
        {
            return true;
        }
        
        s = s.toLowerCase();
        s = s.replaceAll("[^a-z0-9]", "");
        

        int i = 0;
        int j = s.length() - 1;

        while (i < j)
        {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        
        return true;
    }
}
