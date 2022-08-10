public class Leet0005 {

    public static void main(String[] args) {
        longestPalindrome("babad");
    }
    public static String longestPalindrome(String s) {
        String substring;
        int sLength = s.length();
        int currentWindowSize = s.length();
        while (currentWindowSize != 0) {
            for(int i = 0; i + currentWindowSize < sLength + 1; i++)
            {
                substring = s.substring(i, i + currentWindowSize / 2);

                if (isPal(substring))
                {
                    return substring;
                }
            }
            currentWindowSize--;
        }

        return "";
    }

    private static boolean isPal(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right)
        {
            if (s.charAt(left) != s.charAt(right))
            {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
