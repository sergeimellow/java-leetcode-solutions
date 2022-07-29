public class Scrap {
    public static void main(String[] args) {
        String input =  "><<><";
        System.out.println(fixBrac(input));
    }

    public static String fixBrac(String s){
        if(s.length() == 0)
        {
            return "";
        }

        int currentOpenBrackets = 0;
        int leadingOpenBrackets = 0;
        char leftBracket = '<';
        char rightBracket = '>';
        String ret = "";



        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == rightBracket) {
                if (currentOpenBrackets == 0) {
                    leadingOpenBrackets++;
                } else {
                    currentOpenBrackets--;
                }
            } else {
                currentOpenBrackets++;
            }
        }

        // should use string builder here but i'm to lazy since this is scrap
        for (int i =0; i < leadingOpenBrackets; i++)
        {
            ret = ret + leftBracket;
        }

        ret = ret+s;

        for (int i =0; i < currentOpenBrackets; i++)
        {
            ret = ret + rightBracket;
        }

        return ret;
    }
}
